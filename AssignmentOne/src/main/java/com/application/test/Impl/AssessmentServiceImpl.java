package com.application.test.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.application.test.service.AssessmentService;
import com.application.test.service.DuplicateService;
import com.application.test.service.FileService;

@Service
public class AssessmentServiceImpl implements AssessmentService {

	private final FileService fileService;
	private final DuplicateService duplicateService;

	public AssessmentServiceImpl(FileService fileService, DuplicateService duplicateService) {
		this.fileService = fileService;
		this.duplicateService = duplicateService;

	}

	@Override
	public List<String> findDuplicateFileNames(String directoryPath)
	{
		List<File> files=fileService.getAllFiles(directoryPath);
		return duplicateService.findDuplicateFileNames(files);
	}	
}





