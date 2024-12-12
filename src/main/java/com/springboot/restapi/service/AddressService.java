package com.springboot.restapi.service;


import com.springboot.restapi.dto.AddressDto;
import com.springboot.restapi.model.Address;
import com.springboot.restapi.model.Student;
import com.springboot.restapi.repository.AddressRepository;
import com.springboot.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Address saveAddress(AddressDto addressDto){
        Student student = studentRepository.findById(addressDto.getStudentId()).orElseThrow(()-> new RuntimeException("Student not found"));
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());
        address.setStudent(student);
        address.setCountry(addressDto.getCountry());
        address = addressRepository.save(address);

        System.out.println("Address Dto: "+addressDto.toString());
        student.setAddress(address);
        studentRepository.save(student);
        return address;
    }

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
}
