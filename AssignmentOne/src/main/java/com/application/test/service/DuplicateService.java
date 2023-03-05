package com.application.test.service;

import java.io.File;
import java.util.List;

public interface DuplicateService {

	List<String> findDuplicateFileNames(List<File> files);
}
