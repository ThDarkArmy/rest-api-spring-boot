package com.springboot.restapi.service;

import com.springboot.restapi.dto.EnrollCourseDto;
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

    public Course enrollCourse(EnrollCourseDto enrollCourseDto) {
        Student student = studentRepository.findById(enrollCourseDto.getStudentId()).orElseThrow(()-> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(enrollCourseDto.getCourseId()).orElseThrow(()-> new RuntimeException("Course not found"));
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);

        return courseRepository.save(course);
    }
}
