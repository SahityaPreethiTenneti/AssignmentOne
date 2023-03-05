package com.application.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public List<File> getFiles(String folderPath)
	{
//		//System.out.println(folderPath);
//		File folder=new File(folderPath);
//		File[] files=folder.listFiles();
//		return Arrays.asList(files);
		
		List<File> fileList=new ArrayList<>();
		File folder=new File(folderPath);
		if(folder.exists() && folder.isDirectory())
		{
			File[]files=folder.listFiles();
			if(files !=null)
			{
				fileList=Arrays.asList(files);
			}
		}
		return fileList;
	}
}
