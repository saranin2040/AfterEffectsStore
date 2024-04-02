package com.example.demo.controllers;

import com.example.demo.tables.scripts_table.Scripts;
import com.example.demo.tables.scripts_table.ScriptsService;
import com.example.demo.tests.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ExampleController {

    private final ScriptsService scriptsService;

    public ExampleController(ScriptsService scriptsService) {
        this.scriptsService=scriptsService;
    }

    @GetMapping("/api/example")
    public ResponseEntity<String> exampleMethod() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String dataFromDatabase = scriptsService.getPrices();

        return new ResponseEntity<>("{\"message\": \""+dataFromDatabase+"\"}", headers, HttpStatus.OK);
    }



    @GetMapping("/api/get/scripts")
    public ResponseEntity<List<Scripts>> getListScripts() {

        List<Scripts> dataFromDatabase = scriptsService.getAllScripts();

        logger.info("Scripts send");
        return ResponseEntity.ok().body(dataFromDatabase);
    }

    @PostMapping("/api/add/script")
    public ResponseEntity<?> addScript(
            @RequestParam("scriptName") String name,
            @RequestParam("scriptDescription") String description,
            @RequestParam("author") String authorName,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile picture,
            @RequestParam("file") MultipartFile file) {

        logger.info("receive parameters for script");

        // Здесь логика для сохранения файлов на сервере и получения путей
        String pathToPicture = saveFileCloud(picture);
        String pathToFile = saveFileLocal(file);

        logger.info("Files saved");

        // Добавление скрипта в сервис
        Scripts script = scriptsService.addScriptToStore(name, description, price, authorName, pathToPicture, pathToFile);

        logger.info("Script added");

        return ResponseEntity.ok(script); // Или другой подходящий ответ
    }

    @GetMapping("/api/download/script")
    public ResponseEntity<Resource> addScript(@RequestParam("id") String scriptId) {

        String filePath = findFilePathById(scriptId);
        if (filePath == null) {
            logger.warn("File not found 404");
            return ResponseEntity.notFound().build();
        }
        try {
            Path file = Paths.get(filePath);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                String contentType = "application/octet-stream";
                logger.info("File send");
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                logger.warn("file is unreadable");
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            logger.error("MalformedURLException",e);
            return ResponseEntity.notFound().build();
        }
    }



    private String findFilePathById(String id)
    {
        return scriptsService.findPathToFileById(id);
    }

    private String saveFileLocal(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // Указываем путь для сохранения файлов
        String uploadDir = "D:\\All\\files";

        // Создаем директорию, если она не существует
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // Создаем все необходимые директории
        }

        // Генерируем уникальное имя для файла
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Полный путь к файлу
        String filePath = uploadDir + File.separator + fileName;

        try {
            // Сохраняем файл на сервере
            file.transferTo(new File(filePath));
            return filePath; // Возвращаем путь к сохраненному файлу
        } catch (IOException e) {
            // Обработка ошибки в случае неудачного сохранения файла
            e.printStackTrace();
            throw new RuntimeException("Failed to save file");
        }

    }

    private String saveFileCloud(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // Указываем путь для сохранения файлов
        String uploadDir = "D:\\All\\AfterEffectsStore\\my-react-app\\public";

        // Создаем директорию, если она не существует
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // Создаем все необходимые директории
        }

        // Генерируем уникальное имя для файла
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Полный путь к файлу
        String filePath = uploadDir + File.separator + fileName;

        try {
            // Сохраняем файл на сервере
            file.transferTo(new File(filePath));
            return fileName; // Возвращаем путь к сохраненному файлу
        } catch (IOException e) {
            // Обработка ошибки в случае неудачного сохранения файла
            e.printStackTrace();
            throw new RuntimeException("Failed to save file");
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(ScriptsService.class);

}
