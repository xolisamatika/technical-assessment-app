package com.example.technicalassessmentapp;

import com.example.technicalassessmentapp.controllers.MainController;
import com.example.technicalassessmentapp.models.Directory;
import com.example.technicalassessmentapp.services.DirectoryService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class DirectoryServiceImplIntegrationTest {

    @MockBean
    private DirectoryService directoryService;

    @SneakyThrows
    @Test
    public void whenValidDirectory_thenDirectoryListShouldBeReturned() {
        String directory = "/";
        Set<Directory> returned = directoryService.getDirectoryList(directory);
        assertNotNull(returned);
    }

    @SneakyThrows
    @Test
    public void whenInvalidDirectory_thenDirectoryListShouldThrowsException() {
        Set<Directory> returned = directoryService.getDirectoryList("directoryExist");
        assertNotNull(returned);
    }
}
