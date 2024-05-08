package org.spring.Team_project_1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {

//    파일경로
    String saveFiles="file:///C:/openApi/saves/"; //실제 파일이 저장되는 경로


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/***")
            .addResourceLocations(saveFiles);
    }
}
