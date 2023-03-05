package com.example.DuplicateFinder.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DuplicateFinderRepository {
    List<File> findFiles(String directoryPath) throws IOException;
}
