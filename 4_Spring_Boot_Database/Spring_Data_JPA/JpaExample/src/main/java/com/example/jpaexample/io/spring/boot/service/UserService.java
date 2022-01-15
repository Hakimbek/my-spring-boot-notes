package com.example.jpaexample.io.spring.boot.service;

import com.example.jpaexample.io.spring.boot.model.UserRecord;
import com.example.jpaexample.io.spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserRecord> getAllUsers() {
        List<UserRecord> userRecords = new ArrayList<>();
        userRepository.findAll().forEach(userRecords::add);
        return userRecords;
    }

    public void addUser(UserRecord userRecord) {
        userRepository.save(userRecord);
    }

}
