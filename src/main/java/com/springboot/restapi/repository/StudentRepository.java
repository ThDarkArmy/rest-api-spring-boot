package com.springboot.restapi.repository;

import com.springboot.restapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom JPA methods
 // select * from student where name="name";
    List<Student> findByName(String name);
    List<Student> findByAge(int age);

    // select * from student where name="name" and age="age";
    List<Student> findByNameAndAge(String name, int age);

    // select * from student where name="name" and age="age" and country="country;
    List<Student> findByNameAndAgeAndCountry(String name, int age, String country);

    // Custom Query
//    @Query("Select * from student where name=?")
//    List<Student> findByCustomQuery(String name);


    // Custom JPA methods
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

}
