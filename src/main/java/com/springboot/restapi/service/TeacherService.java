package com.springboot.restapi.service;

import com.springboot.restapi.model.Teacher;
import com.springboot.restapi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id){
        return teacherRepository.findById(id).orElseThrow(()-> new RuntimeException("Teacher not found"));
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher, Long id){
        Teacher teacher1 = teacherRepository.findById(id).orElseThrow(()-> new RuntimeException("Teacher not found"));
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    public String deleteTeacher(Long id){
        teacherRepository.findById(id).orElseThrow(()-> new RuntimeException("Teacher not found"));
        teacherRepository.deleteById(id);
        return "Teacher deleted successfully";
    }
}
