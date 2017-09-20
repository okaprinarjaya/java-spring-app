package com.springbootdemo.adeveloperdiary;

import java.util.concurrent.atomic.AtomicLong;

public class Student {
	private long id;
	private String name;
	private String subject;
	private static final AtomicLong lastTimeMs = new AtomicLong();
	
	public Student() {
	}
	
	public Student(String name, String subject) {
		this.id = uniqueCurrentTimeMs();
		this.name = name;
		this.subject = subject;
	}
	
	private static long uniqueCurrentTimeMs() {
		long now = System.currentTimeMillis();
		while (true) {
			long lastTime = lastTimeMs.get();
			if (lastTime >= now) {
				now = lastTime + 1;
			}
			if (lastTimeMs.compareAndSet(lastTime, now)) {
				return now;
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + "', subject='" + subject + "'}";
	}
}
