package com.samanyu.restapi.demo.controller;

import com.samanyu.restapi.demo.repository.*;
import com.samanyu.restapi.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/")
public class studentController {

    @Autowired
    studentRepository studentrepository;

    //Getting data from SQL Database
    @GetMapping(path="/names")
    public List<Student> getAllStudents()
    {
        return studentrepository.findAll();
    }

    //Posting data into SQL Database
    @PostMapping(path = "/add")
    public Student createStudent(@Valid @RequestBody Student std) {
        return studentrepository.save(std);
    }

//    //Updating data
    @PostMapping(path="/update/{id}")
    public Student updateStudent(@PathVariable(value = "id") Long sid, @Valid @RequestBody Student std)
    {
        Student student = studentrepository.findById(sid)
                .orElseThrow(() -> {
                     return null;
                });

        student.setName(std.getName());
        student.setGrade(std.getGrade());
        student.setMarks(std.getMarks());

        Student updated = studentrepository.save(student);
        return updated;

    }
//
//    //Deleting data
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long sid)
    {
        Student student = studentrepository.findById(sid)
                .orElseThrow(()->{
                    return null;
                });

        studentrepository.delete(student);
        return ResponseEntity.ok().build();

    }

}
