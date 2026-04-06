package com.example.betting.common.config.swagger;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "My Spring Boot 4 API",
        version = "v1.0",
        description = "Spring Boot 4 환경에서의 Swagger 문서 테스트입니다."
    )
)
public class SwaggerConfig {

}