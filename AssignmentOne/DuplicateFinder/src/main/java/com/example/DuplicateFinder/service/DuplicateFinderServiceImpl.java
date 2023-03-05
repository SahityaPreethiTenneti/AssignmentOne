package com.example.DuplicateFinder.service;

import com.example.DuplicateFinder.repository.DuplicateFinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DuplicateFinderServiceImpl implements DuplicateFinderService{

    @Autowired
    DuplicateFinderRepository repository;

    @Override
    public List<String> findDuplicateFiles(String directoryPath) throws IOException {
        List<File> files = repository.findFiles(directoryPath);
        Map<String, List<String>> fileMap = new HashMap<>();

        for (File file : files) {
            String key = file.getName() + "_" + file.length();
            if (!fileMap.containsKey(key)) {
                fileMap.put(key, new ArrayList<>());
            }
            fileMap.get(key).add(file.getAbsolutePath());
        }

        List<String> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : fileMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.addAll(entry.getValue());
            }
        }

        return duplicates;
    }
}
