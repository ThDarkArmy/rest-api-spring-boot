package com.springboot.restapi.service;

import com.springboot.restapi.dto.TakeCourseDto;
import com.springboot.restapi.model.Course;
import com.springboot.restapi.model.Student;
import com.springboot.restapi.repository.CourseRepository;
import com.springboot.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Course add(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course takeCourse(TakeCourseDto takeCourseDto) {
        Student student = studentRepository.findById(takeCourseDto.getStudentId()).orElseThrow();
        Course course = courseRepository.findById(takeCourseDto.getCourseId()).orElseThrow();
        // TODO - save the taken courses
        return null;
    }
}
