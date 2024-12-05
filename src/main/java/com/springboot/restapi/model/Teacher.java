package com.springboot.restapi.model;


import jakarta.persistence.*;

@Entity
@Table(name = "teacher_tbl")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(unique = true, name = "email_id")
    private String email;
    private String address;
    private String qualification;
    private String speciality;

    public Teacher() {
    }

    public Teacher(Long id, String name, String email, String address, String qualification, String speciality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.qualification = qualification;
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", qualification='" + qualification + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
