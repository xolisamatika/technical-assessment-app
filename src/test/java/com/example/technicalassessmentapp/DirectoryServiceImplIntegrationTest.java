package com.example.technicalassessmentapp;

import com.example.technicalassessmentapp.models.Directory;
import com.example.technicalassessmentapp.services.DirectoryService;
import com.example.technicalassessmentapp.services.DirectoryServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class DirectoryServiceImplIntegrationTest {

    @TestConfiguration
    static class DirectoryServiceImplTestContextConfiguration {

        @Bean
        public DirectoryService directoryService() {
            return new DirectoryServiceImpl();
        }
    }

    @Autowired
    private DirectoryService directoryService;

    @SneakyThrows
    @Test
    public void whenValidDirectory_thenDirectoryListShouldBeReturned() {
        String name = "alex";
        Set<Directory> returned = directoryService.getDirectoryList(name);
        assertNotNull(returned);
    }
}
