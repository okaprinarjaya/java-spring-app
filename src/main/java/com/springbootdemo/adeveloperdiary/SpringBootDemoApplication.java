package com.springbootdemo.adeveloperdiary;

import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {
	public static HashMap<Long, Student> hmStudent;

	public static void main(String[] args) {
		hmStudent = new HashMap<Long, Student>();
		
		Student studentOne = new Student("John", "Math");
		hmStudent.put(new Long(studentOne.getId()), studentOne);
		
		Student studentTwo = new Student("Michael", "Mechanical Engineering");
		hmStudent.put(new Long(studentTwo.getId()), studentTwo);
			
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
