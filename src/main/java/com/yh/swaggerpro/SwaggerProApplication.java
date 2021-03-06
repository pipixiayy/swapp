package com.yh.swaggerpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.yh.swaggerpro.mapper")
public class SwaggerProApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerProApplication.class, args);
    }

}


