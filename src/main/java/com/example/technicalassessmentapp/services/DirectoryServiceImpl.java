package com.example.technicalassessmentapp.services;

import com.example.technicalassessmentapp.models.Directory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
@Service
public class DirectoryServiceImpl implements DirectoryService {

    /**
     * Obtains the full
     * directory listing of a given path
     *
     * @param directory directory path
     * @return set of directory listing.
     */
    @Override
    public Set<Directory> getDirectoryList(String directory) throws IOException, IllegalArgumentException {
        Set<Directory> directoryList = new HashSet<>();
        Path directoryPath = Paths.get(directory);

        if (!Files.isDirectory(directoryPath))
            throw new IllegalArgumentException("Path must be a directory!");

        try (Stream<Path> walk = Files.walk(directoryPath)) {
             walk.forEach(path -> {
                 Map<String, Object> posix;
                 try {
                     posix = Files
                             .readAttributes(path, "posix:permissions,owner,size,isSymbolicLink,group,isDirectory,isOther,isRegularFile");
                 } catch (IOException e) {
                     log.error("Something went wrong : ", e);
                     return;
                 }
                 directoryList.add(
                            Directory.builder()
                                    .fullPath(path.toAbsolutePath().toString())
                                    .attributeInformation(posix)
                                    .build()
                    );
            });
        }
        return directoryList;
    }
}
