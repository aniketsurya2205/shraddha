package com.reg.event.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reg.event.exception.ResourceNotFoundException;
import com.reg.event.model.Student;
import com.reg.event.service.StudentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public List<Student> getAllEmployees() {
		return studentService.findAll();
	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "studentId") Long studentId)
			throws ResourceNotFoundException {
		Student student = studentService.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
		return ResponseEntity.ok().body(student);
	}

	@PostMapping("/student")
	public Student createStudent(@Validated @RequestBody Student student) {
		System.out.println("In the save method******************************************");
		return studentService.save(student);
	}

	@PutMapping("/students/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "studentId") Long studentId,
			@Validated @RequestBody Student studentDetails) throws ResourceNotFoundException {
		System.out.println("######################################"+studentId);
		Student student = studentService.findById(studentId).orElseThrow(
				() -> new ResourceNotFoundException("Student not found for this studentId :: " + studentId));
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setStudentEmail(studentDetails.getStudentEmail());
		student.setMobNo(studentDetails.getMobNo());
		student.setStudentEvent(studentDetails.getStudentEvent());
		final Student updatedStudent = studentService.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/students/{studentId}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "studentId") Long studentId)
			throws ResourceNotFoundException {
		
		System.out.println("**************"+studentId);
		Student employee = studentService.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

		studentService.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
