package com.example.technicalassessmentapp.controllers;

import com.example.technicalassessmentapp.models.Directory;
import com.example.technicalassessmentapp.services.DirectoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@Slf4j
public class MainController {

    private final DirectoryService service;

    @Autowired
    public MainController(DirectoryService service) {
        this.service = service;
    }

    @GetMapping("/directories")
    public Set<Directory> getDirectories(@RequestParam(name = "directory", defaultValue = "./") String directory) {
        log.info("getDirectories request with directory listing for : " + directory);
        Set<Directory> results = new HashSet<>();
        try {
            results = service.getDirectoryList(directory);
            log.info("getDirectories response for directory listing  for : " + directory + " with results count of " + results.size());
        } catch (IOException e) {
            log.error("Problem getting the directory listing ", e);
        }
        return results;
    }
}
