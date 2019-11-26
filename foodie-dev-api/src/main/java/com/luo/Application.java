package com.luo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan(basePackages = "com.luo.mapper")
public class Application {
    public static void main(String[] args) {
        try{

            SpringApplication.run(Application.class, args);
        }catch(Exception e){
            System.out.println("---"+e.getMessage());
        }
    }
}
