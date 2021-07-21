package com.example.technicalassessmentapp.services;

import com.example.technicalassessmentapp.models.Directory;

import java.io.IOException;
import java.util.Set;

public interface DirectoryService {
    Set<Directory> getDirectoryList(String directoryPath) throws IOException;
}
