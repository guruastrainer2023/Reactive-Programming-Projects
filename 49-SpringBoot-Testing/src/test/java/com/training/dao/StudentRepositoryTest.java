package com.training.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.bean.Student;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentRepositoryTest {

	@Autowired
	StudentDAO dao;
	
	@Test
	public void testRepositoryMethod1() {
		Student student=new Student("Ram", 80);
		
		Student student1=this.dao.save(student);
		
		Student student2=dao.findById(student1.getRollNumber()).orElse(null);
		assertNotNull(student2);
		
		assertEquals(student.getName(), student2.getName());
	}
}
