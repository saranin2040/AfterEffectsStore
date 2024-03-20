package com.example.demo.controllers;

import com.example.demo.tests.CourseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {


    private final CourseService courseService;

    public ExampleController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/api/example")
    public ResponseEntity<String> exampleMethod() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String dataFromDatabase = courseService.printCourseHours();

        System.out.println("che");
        return new ResponseEntity<>("{\"message\": \""+dataFromDatabase+"\"}", headers, HttpStatus.OK);
    }

}
