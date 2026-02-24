package com.asdf.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ApiDocumenttationConfig {

    @Bean
    public OpenAPI apiDocumentation() {
        return new OpenAPI()
            .info(new Info()
                .title("Todolist API")
                .version("1.0")
                .description("Todolist API with Spring Boot")
        );
    }
}
