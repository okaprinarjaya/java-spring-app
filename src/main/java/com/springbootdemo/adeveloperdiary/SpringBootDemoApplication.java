package com.springbootdemo.adeveloperdiary;

import java.util.HashMap;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.couchbase.client.java.Bucket;
//import com.couchbase.client.java.Cluster;
//import com.couchbase.client.java.CouchbaseCluster;

@SpringBootApplication
public class SpringBootDemoApplication {
	public static HashMap<Long, Student> hmStudent;

	public static void main(String[] args) {
//		Logger log = LoggerFactory.getLogger(SpringBootDemoApplication.class);
		
//		final Cluster cluster = CouchbaseCluster.create("localhost");
//		Bucket bucket = cluster.openBucket("judoka");

		hmStudent = new HashMap<Long, Student>();
		
		Student studentOne = new Student("John", "Math");
		hmStudent.put(new Long(studentOne.getId()), studentOne);
		
		Student studentTwo = new Student("Michael", "Mechanical Engineering");
		hmStudent.put(new Long(studentTwo.getId()), studentTwo);
			
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
