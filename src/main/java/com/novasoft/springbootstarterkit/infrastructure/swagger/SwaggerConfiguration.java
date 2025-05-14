package com.novasoft.springbootstarterkit.infrastructure.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerConfiguration {

    @Value("${spring.application.name:Spring Boot Starter Kit}")
    private String applicationName;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title(applicationName)
                        .version("1.0.0")
                        .description("API documentation for the Spring Boot Starter Kit")
                        .contact(new Contact()
                                .name("NovaSoft Development Team")
                                .email("devteam@novasoft.com")
                                .url("https://novasoft.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(getServers())
                .components(securityComponents())
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }

    private List<Server> getServers() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Local Development Server");

        Server devServer = new Server();
        devServer.setUrl("https://dev-api.novasoft.com");
        devServer.setDescription("Development Server");

        Server stagingServer = new Server();
        stagingServer.setUrl("https://staging-api.novasoft.com");
        stagingServer.setDescription("Staging Server");

        Server productionServer = new Server();
        productionServer.setUrl("https://api.novasoft.com");
        productionServer.setDescription("Production Server");

        return Arrays.asList(localServer, devServer, stagingServer, productionServer);
    }

    private Components securityComponents() {
        SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        return new Components()
                .addSecuritySchemes("bearerAuth", bearerAuth);
    }
}