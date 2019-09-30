package com.slabs.pushdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//com.slabs.pushdata.PushdataApplication
//@ComponentScan(basePackages = {"com.slabs.pushdata*"})
@MapperScan("com.slabs.pushdata.dao")
public class PushdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(PushdataApplication.class, args);
    }

}
