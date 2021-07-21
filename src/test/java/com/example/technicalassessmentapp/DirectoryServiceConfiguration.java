package com.example.technicalassessmentapp;

import com.example.technicalassessmentapp.services.DirectoryService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class DirectoryServiceConfiguration {
    @Bean
    @Primary
    public DirectoryService directoryService() {
        return Mockito.mock(DirectoryService.class);
    }
}
