package com.example.inmemorydatabase.io.spring.boot.repository;

import com.example.inmemorydatabase.io.spring.boot.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
