package com.reg.event.service;

import java.util.List;
import java.util.Optional;

import com.reg.event.model.Student;

public interface StudentService {

	List<Student> findAll();
	public Optional<Student> findById(Long studentId);
	public Student save(Student student);
	void delete(Student employee);

}
