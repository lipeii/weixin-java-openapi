package com.weixin.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WeixinJavaOpenapiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinJavaOpenapiServiceApplication.class, args);
    }

}
