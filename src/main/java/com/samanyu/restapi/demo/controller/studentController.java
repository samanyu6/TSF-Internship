package com.samanyu.restapi.demo.controller;

import com.samanyu.restapi.demo.repository.*;
import com.samanyu.restapi.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/")
public class studentController {

    @Autowired
    studentRepository studentrepository;
    @GetMapping(path="/names")
    public List<Student> getAllStudents()
    {
        return studentrepository.findAll();
    }

}
