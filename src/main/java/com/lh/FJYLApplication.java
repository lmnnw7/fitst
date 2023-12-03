package com.lh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.lh.*")
@SpringBootApplication
public class FJYLApplication {

    public static void main(String[] args) {
        SpringApplication.run(FJYLApplication.class, args);
    }

}
