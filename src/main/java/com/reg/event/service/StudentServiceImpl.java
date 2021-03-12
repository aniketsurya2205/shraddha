package com.reg.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reg.event.model.Student;
import com.reg.event.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> findAll() {
		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public Optional<Student> findById(Long studentId) {
		return studentRepo.findById(studentId);

	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public void delete(Student student) {
		studentRepo.delete(student);

	}

}
