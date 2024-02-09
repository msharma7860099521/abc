package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.CustomException.BussinessException;
import com.example.demo.entity.Student;
import com.example.demo.model.StudentRepository;


@SpringBootTest
class StudentServiceTest2 {

	@InjectMocks
	StudentService service;
	
	@Mock
	StudentRepository repo;
	
	
	@Test
	@Ignore
    public	void getstudentbyid() {
		when(repo.findById(1)).thenReturn(createEmployeeStub());
		Student student= service.getStudentById(1);
		assertEquals(student.getStudent_name(), "kashama");
	
	}
	
	@Test
    public	void checkException() {
	BussinessException bussinessexception=	assertThrows(BussinessException.class, ()-> service.getStudentById(0));
		assertEquals(bussinessexception.getExceptionDescription(), "please provide student Id");
	
	}
	
	
	private Optional<Student> createEmployeeStub(){
		Student stu=new Student().builder().student_name("kashama").student_age(22).student_address("gyanpur").build();
		return Optional.of(stu);
	}

}
