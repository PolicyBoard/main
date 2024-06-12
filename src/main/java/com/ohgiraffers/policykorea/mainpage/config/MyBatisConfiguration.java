package com.ohgiraffers.policykorea.mainpage.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.policykorea", annotationClass = Mapper.class)
public class MyBatisConfiguration {
}
