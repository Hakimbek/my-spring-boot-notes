package com.example.springcaching.io.spring.boot.controler;

import com.example.springcaching.io.spring.boot.model.Customer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @RequestMapping("/customerInfo")
    @Cacheable(value = "customerInfo")
    public List<Customer> customerInformation() {
        System.out.println("Customer information from cache");

        List<Customer> detail = Arrays.asList(
                new Customer(5126890, "Alex Doe", "Current A/c", 450000.00),
                new Customer(7620015, "Andrew McArtur", "Saving A/c", 210089.00)
        );

        return detail;
    }
}
