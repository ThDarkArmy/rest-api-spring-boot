package com.springboot.restapi.controller;

import com.springboot.restapi.dto.AddressDto;
import com.springboot.restapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

@RequestMapping("/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return status(HttpStatus.OK).body(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody AddressDto addressDto){
        return status(HttpStatus.CREATED).body(addressService.saveAddress(addressDto));
    }
}
