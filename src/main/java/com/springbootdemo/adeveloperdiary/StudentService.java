package com.springbootdemo.adeveloperdiary;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/student")
public class StudentService {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HashMap<Long, Student> getAllStudents() {
		return SpringBootDemoApplication.hmStudent;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Student addStudent(
			@RequestParam(value="name") String name,
			@RequestParam(value="subject", defaultValue = "Unknown") String subject
	) {
		Student student = new Student(name, subject);
		SpringBootDemoApplication.hmStudent.put(new Long(student.getId()), student);
		return student;
	}
	
}
