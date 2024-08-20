package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")

public class StudentController {
private final StudentService studentService; // studentService is an object (instance) created from the StudentService class

@Autowired    //This automatically inject an instance of StudentService when creating the StudentController object.
public StudentController(StudentService studentService){
    this.studentService = studentService;
}

@GetMapping //This annotation means that this method will handle GET requests
    public List<Student> getStudents(){

    return studentService.getStudents();
}
@PostMapping
    public void registerNewStudent(@RequestBody Student student){
    studentService.addNewStudent(student);
}
@DeleteMapping(path = "{studentId}")
public void deleteStudent(@PathVariable ("studentId")Long studentId){
    studentService.deleteStudent(studentId);
}
    }



