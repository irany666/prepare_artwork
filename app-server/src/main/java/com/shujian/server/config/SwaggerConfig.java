package com.shujian.server.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by shujian.ou 2022/6/6 15:59
 */
@Configurable
@Component
@EnableOpenApi
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shujian.server.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact defaultContact = new Contact("PREPARE ARTWORK", "default", "default");
        return new ApiInfo("PREPARE ARTWORK 接口文档", "", "8888", "",
                defaultContact, "default", "default", new ArrayList<>());
    }
}
