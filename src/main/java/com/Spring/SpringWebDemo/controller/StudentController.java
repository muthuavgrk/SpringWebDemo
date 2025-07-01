package com.Spring.SpringWebDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.SpringWebDemo.model.Student;
import com.Spring.SpringWebDemo.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        if(studentService.getStudentById(id) == null)
            return new ResponseEntity<>("Student not found",HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);


    }

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
