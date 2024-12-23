package com.springboot.restapi.controller;

import com.springboot.restapi.dto.EnrollCourseDto;
import com.springboot.restapi.model.Course;
import com.springboot.restapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

@RequestMapping("/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return status(HttpStatus.OK).body(courseService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Course course){
        return status(HttpStatus.CREATED).body(courseService.add(course));
    }

    @PostMapping("/enroll-course")
    public ResponseEntity<?> enrollCourse(@RequestBody EnrollCourseDto enrollCourseDto){
        return status(HttpStatus.CREATED).body(courseService.enrollCourse(enrollCourseDto));
    }
}
