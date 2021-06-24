package com.yh.swaggerpro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: swagger-pro
 * @Date: 2021/5/20 20:46
 * @Author: YH
 * @Description:
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerDemoApiInfo()) .select() .build();
    }

    private ApiInfo swaggerDemoApiInfo(){
        return new ApiInfoBuilder()
                .contact(new Contact("xxx平台", "http://www.xxxxx.com", "xxx@163.com"))
                .title("Swagger标题")  //文档标题
                .description("Swagger描述信息")   //文档描述
                .version("1.0.0") .build();  //文档版本
    }
}
