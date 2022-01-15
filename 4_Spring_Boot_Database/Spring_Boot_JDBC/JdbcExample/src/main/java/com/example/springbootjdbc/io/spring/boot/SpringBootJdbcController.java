package com.example.springbootjdbc.io.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootJdbcController {

    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping("/insert")
    public String index() {
        jdbc.execute("insert into " + "\"" + "user" + "\"" + " values(2, 'Hakim','hakim@gmail.com')");
        return "Data inserted Successfully";
    }

}
