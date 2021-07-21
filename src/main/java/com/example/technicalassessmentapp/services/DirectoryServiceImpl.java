package com.example.technicalassessmentapp.services;

import com.example.technicalassessmentapp.models.Directory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class DirectoryServiceImpl implements DirectoryService {

    @Override
    public Set<Directory> getDirectoryList(String directory) throws IOException {
        Set<Directory> directoryList = new HashSet<>();
        Path directoryPath = Paths.get(directory);

        if (!Files.isDirectory(directoryPath))
            throw new IllegalArgumentException("Path must be a directory!");

        try (Stream<Path> walk = Files.walk(directoryPath)) {
             walk.forEach(path -> {
                try {
                    Map<String, Object> posix = Files
                            .readAttributes(path, "posix:permissions,owner,size,isSymbolicLink,group,isDirectory,isOther,isRegularFile");

                    directoryList.add(
                            Directory.builder()
                                    .fullPath(path.toAbsolutePath().toString())
                                    .attributeInformation(posix)
                                    .build()
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return directoryList;
    }
}
