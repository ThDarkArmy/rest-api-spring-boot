package com.springboot.restapi.controller;

import com.springboot.restapi.model.Teacher;
import com.springboot.restapi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // getting all the teachers
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return status(HttpStatus.OK).body(teacherService.getAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return status(HttpStatus.OK).body(teacherService.getTeacherById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher){
        return status(HttpStatus.CREATED).body(teacherService.addTeacher(teacher));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        return status(HttpStatus.OK).body(teacherService.updateTeacher(teacher, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id){
        return status(HttpStatus.OK).body(teacherService.deleteTeacher(id));
    }

}
