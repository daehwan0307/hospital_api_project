package com.springboot.hello.controller;


import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.Hospital;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/hospital",method = RequestMethod.GET)
public class HospitalController {


    private final HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> get(@PathVariable Integer id) {
        Hospital hospital = hospitalDao.findById(id);
        Optional<Hospital> opt = Optional.of(hospital);

        if (!opt.isEmpty()) {
            return ResponseEntity.ok().body(hospital);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }
    }
    @GetMapping("/get/{id}")
    public String get1(@PathVariable Integer id) {
        Hospital hospital = hospitalDao.findById(id);
        return hospital.getFullAddress();
    }

}
