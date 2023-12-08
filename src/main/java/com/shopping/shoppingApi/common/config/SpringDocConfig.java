package com.shopping.shoppingApi.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class SpringDocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info().title("Shopping API")
                        .description("Shopping API 文档")
                        .version("1.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact().name("wg233")));
    }
}
