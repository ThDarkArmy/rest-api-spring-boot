package com.springboot.restapi.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentDto {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Country cannot be empty")
    private String country;
    @NotNull(message = "Age must not be null")
    @Max(value = 35, message = "Maximum age must be less than or equal to 35")
    @Min(value = 4, message = "Minimum age must be greater than or equal to 4")
    private int age;
    private Long classTeacherId;

    public StudentDto() {
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

    public Long getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(Long classTeacherId) {
        this.classTeacherId = classTeacherId;
    }
}
