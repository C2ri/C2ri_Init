package com.c2ri.project.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Configuration


//localhost:8080/swagger-ui/index.html
@OpenAPIDefinition(
    info = Info(title       = "셔를레이호 App",
                description = "셔를레이호 API 명세",
                version     = "v1"))
@RequiredArgsConstructor
@Configuration
class SwaggerConfig {
}