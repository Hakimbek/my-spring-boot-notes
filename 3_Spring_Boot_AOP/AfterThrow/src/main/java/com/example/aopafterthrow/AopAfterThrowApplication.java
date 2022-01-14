package com.example.aopafterthrow;

import com.example.aopafterthrow.io.spring.boot.model.Account;
import com.example.aopafterthrow.io.spring.boot.service.impl.AccountServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopAfterThrowApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopAfterThrowApplication.class, args);
        AccountServiceImpl accountServiceImpl = context.getBean(AccountServiceImpl.class);
        Account account;
        try {
            //generating exception
            account = accountServiceImpl.getAccountByCustomerId(null);
            if (account != null)
                System.out.println(account.getAccountNumber() + "\t" + account.getAccountType());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
