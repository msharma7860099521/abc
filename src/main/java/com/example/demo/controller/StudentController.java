package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("sys")
public class StudentController {

@Autowired
StudentService studentService;

@PostMapping("/addStudent")
public ResponseEntity<Student> addStudent(@RequestBody Student student) {

	Student addedStdent = studentService.saveStudent(student);
	return new ResponseEntity<Student>(addedStdent, HttpStatus.ACCEPTED);

}

@GetMapping("/getStudent/{id}")
public ResponseEntity<Student> findStudentById(@PathVariable int id  ) {
	
	Student student =studentService.getStudentById(id);
	return new ResponseEntity<Student>(student, HttpStatus.OK);

}




	
}
