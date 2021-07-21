package com.example.technicalassessmentapp.controllers;

import com.example.technicalassessmentapp.models.Directory;
import com.example.technicalassessmentapp.services.DirectoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestController
public class MainController {

    private final DirectoryService service;

    @Autowired
    public MainController(DirectoryService service) {
        this.service = service;
    }

    /**
     * Obtains the full
     * directory listing of a given path
     *
     * @param directory directory path
     * @return set of directory listing.
     */
    @GetMapping("/directories")
    public Set<Directory> getDirectories(@RequestParam(name = "directory", defaultValue = "./") String directory) throws Exception {
        log.info("getDirectories request with directory listing for : " + directory);
        Set<Directory> results;
        try {
            results = service.getDirectoryList(directory);
            log.info("getDirectories response for directory listing  for : " + directory + " with results count of " + results.size());
        } catch (Exception e) {
            log.error("Problem getting the directory listing ", e);
            throw new Exception("Problem getting the directory listing ", e);
        }
        return results;
    }
}
