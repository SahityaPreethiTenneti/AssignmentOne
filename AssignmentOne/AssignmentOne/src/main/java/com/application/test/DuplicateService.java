package com.application.test;

import java.io.File;
import java.util.List;

public interface DuplicateService {

	List<File> findDuplicates(List<File> files);
}
