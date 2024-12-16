package com.springboot.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
* oneToOne - student with seat in class
* OneToMany - Student can take n number of books from library
* ManyToOne - A book can be taken by only 1 student at a time.
*
* */

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Country cannot be empty")
    private String country;
    @Max(value = 35, message = "Maximum age must be less than or equal to 35")
    @Min(value = 4, message = "Minimum age must be greater than or equal to 4")
    @NotNull(message = "Age must not be null")
    private int age;

    @OneToOne(mappedBy = "student")
    private Address address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "class_teacher_id", nullable = false)
    private Teacher classTeacher;

    private LocalDate created_at;
    private LocalDate updated_at;

    @ManyToMany
    @JoinTable(
            name = "course_taken",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> courses = new ArrayList<>();


    public Student() {
    }

    public Student(Long id, String name, String country, int age) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Teacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + country + '\'' +
                ", age=" + age +
                '}';
    }
}
