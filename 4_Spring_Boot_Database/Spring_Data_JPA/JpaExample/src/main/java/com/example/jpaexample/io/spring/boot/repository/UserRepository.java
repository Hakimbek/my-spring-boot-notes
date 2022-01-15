package com.example.jpaexample.io.spring.boot.repository;

import com.example.jpaexample.io.spring.boot.model.UserRecord;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserRecord, String> {

}
