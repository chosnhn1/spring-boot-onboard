package com.asdf.todo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocumenttationConfig {

    @Bean
    public OpenAPI apiDocumentation() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Todolist API")
                                .version("2.0")
                                .description("Todolist API with Spring Boot"));
    }
}
