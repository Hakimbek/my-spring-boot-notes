package com.example.aopreturningadvice;

import com.example.aopreturningadvice.io.spring.boot.model.Account;
import com.example.aopreturningadvice.io.spring.boot.service.impl.AccountServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopReturningAdviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopReturningAdviceApplication.class, args);
        AccountServiceImpl accountServiceImpl = context.getBean(AccountServiceImpl.class);
        Account account;
        try {
            account = accountServiceImpl.getAccountByCustomerId("K2434567");
            if (account != null)
                System.out.println(account.getAccountNumber() + "\t" + account.getAccountType());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
