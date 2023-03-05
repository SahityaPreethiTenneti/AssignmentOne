package com.example.DuplicateFinder.repository;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class DuplicateFinderRepositoryImpl implements DuplicateFinderRepository{

    @Override
    public List<File> findFiles(String directoryPath) throws IOException {
        List<File> files = (List<File>) FileUtils.listFiles(new File(directoryPath), null, true);
        return files;
    }
}
