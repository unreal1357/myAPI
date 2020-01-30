package com.RESTAPI.myAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //makes a config file
@EnableSwagger2 //enables swagger
public class SwaggerConfig {

    //creating a new bean
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
