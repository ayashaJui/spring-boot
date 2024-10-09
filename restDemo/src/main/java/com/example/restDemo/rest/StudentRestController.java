package com.example.restDemo.rest;

import com.example.restDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Smith"));
        theStudents.add(new Student("Paul", "Martin"));
    }
    // define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if((studentId >= theStudents.size()) || (studentId <= 0)){
            throw new StudentNotFoundException("Student Id not found: " +studentId);
        }
        return theStudents.get(studentId);
    }


}
