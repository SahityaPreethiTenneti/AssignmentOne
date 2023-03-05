package com.application.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DuplicateServiceImpl implements DuplicateService{

	public List<File> findDuplicates(List<File> files)
	{
		List<File> duplicates=new ArrayList<>();
		Set<String> fileNames=new HashSet<>();
		
		for(File file:files)
		{
			if(!file.isDirectory())
			{
				String fileName=file.getName();
				if(fileNames.contains(fileName))
				{
					duplicates.add(file);
				}
				else
				{
					fileNames.add(fileName);
				}
			}
		}
		return duplicates;
	}
}
