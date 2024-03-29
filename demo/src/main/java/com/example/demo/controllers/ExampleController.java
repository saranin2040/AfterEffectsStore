package com.example.demo.controllers;

import com.example.demo.tables.scripts_table.Scripts;
import com.example.demo.tables.scripts_table.ScriptsService;
import com.example.demo.tests.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {


    private final CourseService courseService;
    private final ScriptsService scriptsService;

    public ExampleController(CourseService courseService, ScriptsService scriptsService) {
        this.courseService = courseService;
        this.scriptsService=scriptsService;
    }

    @GetMapping("/api/example")
    public ResponseEntity<String> exampleMethod() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String dataFromDatabase = scriptsService.getPrices();

        System.out.println("che");
        return new ResponseEntity<>("{\"message\": \""+dataFromDatabase+"\"}", headers, HttpStatus.OK);
    }



    @GetMapping("/api/get/scripts")
    public ResponseEntity<List<Scripts>> getListScripts() {

        List<Scripts> dataFromDatabase = scriptsService.getAllScripts();
        return ResponseEntity.ok().body(dataFromDatabase);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        String dataFromDatabase = scriptsService.getPrices();
//
//        System.out.println("che");
//        return new ResponseEntity<>("{\"message\": \""+dataFromDatabase+"\"}", headers, HttpStatus.OK);
    }

}
