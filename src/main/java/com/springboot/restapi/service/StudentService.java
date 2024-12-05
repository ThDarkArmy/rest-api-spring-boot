package com.springboot.restapi.service;

import com.springboot.restapi.model.Student;
import com.springboot.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Constructor Injection
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll(); // Select * from student
    }

    public Student addStudent(Student student){
        student.setCreated_at(LocalDate.now());
        //write some logic to save that file in some storage like aws s3 bucket or some kind of server
        // we need to create path for that file and then we can store that path in our database
        return studentRepository.save(student); // Insert into student values(id, name, age, address)
    }

    public Student updateStudent(Long id, Student student){
        Student student1 = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        student.setId(id);
        student.setUpdated_at(LocalDate.now());
        return studentRepository.save(student);
    }

    public Student updateStudentAge(Long id, Integer age){
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        student.setAge(age);
        return studentRepository.save(student);
    }

    public String deleteStudent(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        studentRepository.deleteById(id);
        return "Student deleted successfully";

    }
}
