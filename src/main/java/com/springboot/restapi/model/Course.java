package com.springboot.restapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String subject;
    private String duration;
    private LocalDate startDate;

    @ManyToMany
    private List<Student> students;

    public Course() {
    }

    public Course(Long courseId, String subject, String duration, LocalDate startDate) {
        this.courseId = courseId;
        this.subject = subject;
        this.duration = duration;
        this.startDate = startDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", subject='" + subject + '\'' +
                ", duration='" + duration + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
