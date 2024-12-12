package com.springboot.restapi.controller;

import com.springboot.restapi.dto.StudentDto;
import com.springboot.restapi.model.Student;
import com.springboot.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents(){
//        return new ResponseEntity<String>("Student", HttpStatus.OK);
        return status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
        return status(HttpStatus.OK).body(studentService.addStudent(studentDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student){
        return status(HttpStatus.OK).body(studentService.updateStudent(id, student));
    }

    @PatchMapping("/update/age/{id}")
    public ResponseEntity<?> updateStudentAge(@PathVariable Long id, @RequestBody Integer age){
        return status(HttpStatus.OK).body(studentService.updateStudentAge(id, age));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        return status(HttpStatus.OK).body(studentService.deleteStudent(id));
    }

    /*i
    * 200 - OK
    * 401 - Unauthorized
    * 404 - Not found
    * 500 - Internak Server error
    * */

    /*
    *  Get:- Read/get some data from database/backend/server
    *  Post:- Add/Save/Post to the databse/server/backend
    *  Put:- Update/Edit the data
    *  Delete:- Delete the data
    *  Patch:- Update/edit
    *
    *
    * */

    /*
    * Add dependency mysql-connector
    * add configuration for database
    * to make some operations in db(read/write/update/delete) we need JPA
    * */

}
