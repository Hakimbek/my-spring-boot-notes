package com.example.aopafterthrow.io.spring.boot.service.impl;

import com.example.aopafterthrow.io.spring.boot.model.Account;

public interface AccountService {

    public abstract Account getAccountByCustomerId(String customerId) throws Exception;

}
