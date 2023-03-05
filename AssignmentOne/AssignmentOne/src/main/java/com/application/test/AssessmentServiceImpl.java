package com.application.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class AssessmentServiceImpl implements AssessmentService {

	private final FileService fileService;
	private final DuplicateService duplicateService;

	public AssessmentServiceImpl(FileService fileService, DuplicateService duplicateService) {
		this.fileService = fileService;
		this.duplicateService = duplicateService;

	}

	public Map<String,List<String>> runAssessment(String folderPath)
	{
		Map<String,List<String>> fileMap=new HashMap<>();
		
		File folder=new File(folderPath);
		File[] files=folder.listFiles();
		
		if(files==null)
		{
			return fileMap;
		}
		
		for(File file:files)
		{
			if(!file.isDirectory()) {
				String fileName=file.getName();
				String[] fileParts=fileName.split("\\.");
				
				if(fileParts.length>1)
				{
					String fileType=fileParts[fileParts.length-1];
					if(!fileMap.containsKey(fileType)) {
						fileMap.put(fileType,new ArrayList<>());
					}
					fileMap.get(fileType).add(fileName);
				}
			}
		}
		
		Map<String,List<String>> duplicateFiles=new HashMap<>();
		
		for(Entry<String,List<String>> entry:fileMap.entrySet()) {
			List<String> fileList=entry.getValue();
			Set<String> set=new HashSet<>();
			List<String> duplicateFileList=new ArrayList<>();
			
			for(String fileName:fileList)
			{
				String[] fileNameParts=fileName.split("\\.");
				String filePrefix=fileNameParts[0];
				
				if(!set.contains(filePrefix)) {
					set.add(filePrefix);
				}
				else
				{
					if(!duplicateFileList.contains(filePrefix)) {
						duplicateFileList.add(filePrefix);
					}
				}
			}
			
			if(duplicateFileList.size()>0)
			{
				duplicateFiles.put(entry.getKey(),duplicateFileList);
			}
		}
		return duplicateFiles;
		
		
	}
	
	
	
	
	
}





