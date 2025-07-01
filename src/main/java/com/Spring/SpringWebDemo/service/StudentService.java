package com.Spring.SpringWebDemo.service;

import com.Spring.SpringWebDemo.model.Student;
import com.Spring.SpringWebDemo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;



    public Student getStudentById(int id) {
        return repo.findAll().stream().filter(s->s.getId()==id).findFirst()
                .orElse(new Student());
    }

    public List<Student> getStudent(){
        /*ArrayList<Student> students = new ArrayList<>(List.of(
                new Student(1, "Ashvik", 100),
                new Student(2,"Aarvi", 100)
        )) ;
        return students;*/
        return repo.findAll();
    }

    public Student addStudent(Student student) {
       return repo.save(student);
    }

    public Student updateStudent(Student student) {
        return repo.save(student);
    }
}
