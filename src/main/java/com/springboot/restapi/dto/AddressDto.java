package com.springboot.restapi.dto;


public class AddressDto {
    private String country;
    private String city;
    private String zipCode;
    private Long studentId;

    public AddressDto() {
    }

    public AddressDto(String country, String city, String zipCode, Long studentId) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.studentId = studentId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
