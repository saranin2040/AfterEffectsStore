package com.example.demo.tests;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.tests.Course;

public interface  CourseRepository extends JpaRepository<Course, Long> {
}
