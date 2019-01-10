package com.alibaba.xinan.sirs;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author XinAnzzZ
 * @date 2018/11/13 13:32
 */
@SpringBootApplication
@MapperScan(basePackages = "com.alibaba.xinan.sirs.mapper", annotationClass = Mapper.class)
public class SupermarketItemRetrievalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermarketItemRetrievalSystemApplication.class, args);
    }
}
