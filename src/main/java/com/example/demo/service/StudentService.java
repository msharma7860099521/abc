package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CustomException.BussinessException;
import com.example.demo.entity.Student;
import com.example.demo.model.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		
	Student saveStudent=studentRepository.save(student);
	
	return saveStudent;	
	}

	public Student getStudentById(int student_id) {
		Student student=null;
		
		if(student_id==0) {
			throw new BussinessException(600,"please provide student Id");
		}
		
		try {
		    student=studentRepository.findById(student_id).get();
		} catch (Exception e) {
			
			throw new BussinessException(601,e.getMessage());
		}
		
		return student;
	}

	

}
