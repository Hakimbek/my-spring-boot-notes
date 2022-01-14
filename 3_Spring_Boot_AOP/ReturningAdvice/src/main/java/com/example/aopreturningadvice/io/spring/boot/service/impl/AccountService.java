package com.example.aopreturningadvice.io.spring.boot.service.impl;

import com.example.aopreturningadvice.io.spring.boot.model.Account;

public interface AccountService {

    public abstract Account getAccountByCustomerId(String customerId) throws Exception;

}
