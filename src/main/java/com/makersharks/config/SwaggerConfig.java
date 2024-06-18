package com.makersharks.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition (
        info = @Info(
                title = "MakerSharks Task Documentation",
                version = "1.0",
                description = "Complete API documentation for spring application."),
        servers = {
                @Server(
                        url = "http://localhost:8181",
                        description = "Local server"
                ),
                @Server(
                        url = "https://makersharks.pranavbisaria.live",
                        description = "Production server"
                )
        }
)
public class SwaggerConfig {
}