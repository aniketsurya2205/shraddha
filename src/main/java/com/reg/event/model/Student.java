package com.reg.event.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	private String firstName;
	private String lastName;
	private String mobNo;
	private String studentEmail;
	private String studentEvent;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentEvent() {
		return studentEvent;
	}

	public void setStudentEvent(String studentEvent) {
		this.studentEvent = studentEvent;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobNo="
				+ mobNo + ", studentEmail=" + studentEmail + ", studentEvent=" + studentEvent + "]";
	}

	public Student(long studentId, String firstName, String lastName, String mobNo, String studentEmail,
			String studentEvent) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNo = mobNo;
		this.studentEmail = studentEmail;
		this.studentEvent = studentEvent;
	}

	public Student() {
		super();
	}

}
