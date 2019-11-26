package com.luo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        try{

            SpringApplication.run(Application.class, args);
        }catch(Exception e){
            System.out.println("---"+e.getMessage());
        }
    }
}
