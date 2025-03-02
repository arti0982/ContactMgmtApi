package com.belong.contactmgmtapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPI30
@OpenAPIDefinition(
        info = @Info(
                title = "Customer Phone Number API",
                version = "1.0.0",
                description = "API for managing customer phone numbers",
                contact = @Contact(
                        name = "API Support",
                        url = "https://belong.example.com/support",
                        email = "support@belong.example.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local server"),
        }
)

public class ContactMgmtApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactMgmtApiApplication.class, args);
    }

}
