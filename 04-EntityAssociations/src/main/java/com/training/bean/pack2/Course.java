package com.training.bean.pack2;

import java.util.HashSet;
import java.util.Set;

public class Course {
	int courseId;
	String courseName;
	double fee;
	Set<Subject> subjects;
	
	
	private void init() {
		if(this.subjects==null)
			this.subjects=new HashSet<Subject>();
	}
	public Course() {
		super();
		init();
	}



	public Course(int courseId) {
		super();
		this.courseId = courseId;
		init();
	}



	public Course(String courseName, double fee) {
		super();
		this.courseName = courseName;
		this.fee = fee;
		init();
	}



	public Course(int courseId, String courseName, double fee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fee = fee;
		init();
	}



	


	public Course(int courseId, String courseName, double fee, Set<Subject> subjects) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fee = fee;
		this.subjects = subjects;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public double getFee() {
		return fee;
	}



	public void setFee(double fee) {
		this.fee = fee;
	}



	public Set<Subject> getSubjects() {
		return subjects;
	}



	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public boolean addSubject(Subject subject) {
		return this.subjects.add(subject);
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", fee=" + fee + ", subjects=" + subjects
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		return true;
	}
	
	
	
}
