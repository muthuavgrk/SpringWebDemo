package com.Spring.SpringWebDemo.controller;

import com.Spring.SpringWebDemo.service.StudentService;
import com.Spring.SpringWebDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents(){
        return  new ResponseEntity<>(studentService.getStudent(), HttpStatus.OK);

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.CREATED);

    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.ACCEPTED);
    }





}
