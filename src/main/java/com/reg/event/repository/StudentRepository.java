package com.reg.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.reg.event.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
