package com.ohgiraffers.policykorea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ohgiraffers.policykorea.board.config")
public class PolicyKoreaApplication {

    public static void main(String[] args) {

        SpringApplication.run(PolicyKoreaApplication.class, args);

    }

}
