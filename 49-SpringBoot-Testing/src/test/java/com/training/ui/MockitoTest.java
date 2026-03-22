package com.training.ui;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.bean.Student;
import com.training.dao.StudentDAO;
import com.training.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoTest {
	
	@Autowired
	StudentService service;
	
	@MockBean
	StudentDAO dao;
	
	@Test
	public void getAllStudentsTest() {
		List<Student> mockedStudentList=new ArrayList<>();
		mockedStudentList.add(new Student(101,"Ram", 55));
		mockedStudentList.add(new Student(102,"Sri Devi", 66));
		
		when(dao.findAll()).thenReturn(mockedStudentList);
		
		assertEquals(2,this.service.getAllStudents().size());
		
	}
	
	@Test
	public void getAllStudentsByMarksTest() {
		List<Student> mockedStudentList=new ArrayList<>();
		mockedStudentList.add(new Student(101,"Ram", 55));
		
		
		when(dao.findStudentsByMarks(55)).thenReturn(mockedStudentList);
		
		assertEquals(1,this.service.getAllStudentsByMark(55).size());
		
	}
	
	@Test
	public void addStudentTest() {
		Student student=new Student(103, "Reshmi", 44);
		
		when(this.dao.save(student)).thenReturn(student);
		
		assertEquals(student, this.service.addStudent(student));
	}
	
	@Test
	public void deleteStudentTest() {
		Student student=new Student(103, "Reshmi", 44);
		this.service.deleteStudent(student);
		verify(dao, times(1)).delete(student);
	}
	

}
