package com.example.demo.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public String printCourseHours() {
        List<Course> courses = courseRepository.findAll();
        String s="";
        for(Course course : courses) {
            s=s+course.getHours()+" ";
            System.out.println(course.getHours());
        }
        return s;
    }
}
