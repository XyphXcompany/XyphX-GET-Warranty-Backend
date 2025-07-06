package com.xyphx.getwarranty.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                                .allowedOrigins("http://localhost:8081", "http://localhost:8080", "https://getwarranty.vercel.app")
                                .allowedMethods("*")
                                .allowedHeaders("*")
                                .allowCredentials(true);
        }
}
