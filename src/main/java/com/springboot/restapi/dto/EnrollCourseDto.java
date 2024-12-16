package com.springboot.restapi.dto;


public class EnrollCourseDto {
    private Long courseId;
    private Long studentId;

    public EnrollCourseDto() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
