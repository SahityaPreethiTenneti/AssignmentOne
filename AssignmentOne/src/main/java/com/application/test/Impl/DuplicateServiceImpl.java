package com.application.test.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import com.application.test.service.DuplicateService;

@Service
public class DuplicateServiceImpl implements DuplicateService{

	@Override
	public List<String> findDuplicateFileNames(List<File> files)
	{
		List<String> fileNames=new ArrayList<>();
		List<String> duplicates=new ArrayList<>();
		
		for(File file:files)
		{
			if(file.isFile()) {
				String fileName=file.getName();
				String baseName=FilenameUtils.getBaseName(fileName);
				
				if(!fileNames.contains(baseName)) {
					fileNames.add(baseName);
				}else if(!duplicates.contains(baseName)) {
					duplicates.add(baseName);
				}
			}
		}
		return duplicates;
	}
}
