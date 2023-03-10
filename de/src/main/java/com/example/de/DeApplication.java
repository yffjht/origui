package com.example.de;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@SpringBootApplication
@MapperScan("com.example.de.mapper")//启动mapper扫描
public class DeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeApplication.class, args);
    }
//    @RequestMapping("/")
//    public String test(){
//        return "111";
//    }
}
