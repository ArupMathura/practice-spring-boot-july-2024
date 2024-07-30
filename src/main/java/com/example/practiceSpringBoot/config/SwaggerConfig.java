package com.example.practiceSpringBoot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring boot REST api")
                        .description("Here I am practicing spring boot rest api")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Arup Mathura")
                                .email("arupmathura@gmail.com")));
    }
}


