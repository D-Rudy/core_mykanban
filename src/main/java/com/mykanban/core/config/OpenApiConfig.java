package com.mykanban.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8081");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("rdz");
        myContact.setEmail("your.email@gmail.com");

        Info information = new Info()
                .title("MyKanban System API")
                .version("1.0")
                .description("This API expose endpoint to manage boards, columns and tickets.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}

