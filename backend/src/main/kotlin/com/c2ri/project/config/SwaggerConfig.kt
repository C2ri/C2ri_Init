package com.c2ri.project.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

////localhost:8080/swagger-ui/index.html
@OpenAPIDefinition(
        info = Info(title = "셔를레이호 App",
                description = "셔를레이호 API 명세",
                version = "v1"))
@Configuration
class SwaggerConfig {

    //Token 인증을 위한 설정
    @Bean
    fun customOpenAPI(): OpenAPI {
        val securitySchemeName = "bearerAuth"
        return OpenAPI()
                .addSecurityItem(SecurityRequirement().addList(securitySchemeName))
                .components(
                        Components()
                                .addSecuritySchemes(securitySchemeName,
                                        SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
    }
}