package com.example.DuplicateFinder.service;

import java.io.IOException;
import java.util.List;

public interface DuplicateFinderService {
    List<String> findDuplicateFiles(String directoryPath) throws IOException;
}
