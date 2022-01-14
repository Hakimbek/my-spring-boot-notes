package com.example.aoparoundadvice;

import com.example.aoparoundadvice.io.spring.boot.service.BankService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopAroundAdviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopAroundAdviceApplication.class, args);
        // Fetching the employee object from the application context.
        BankService bank = context.getBean(BankService.class);
        String accNumber = "12345";
        bank.displayBalance(accNumber);
        context.close();
    }

}
