package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.CustomException.BussinessException;
import com.example.demo.entity.Student;
import com.example.demo.model.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	
	@Autowired
	PasswordEncoder encoder;
	
	
	public Student saveStudent(Student student) {
		
	Student saveStudent=studentRepository.save(student);
	
	return saveStudent;	
	}

	public Student getStudentById(int student_id) {
		Student student = null;
		Optional<Student> e = studentRepository.findById(student_id);

		if (e.isPresent()) {

			return e.get();
		} else {

			throw new BussinessException(6011, "sorry student with given id not present.");

		}

	}

	
	
	

}
