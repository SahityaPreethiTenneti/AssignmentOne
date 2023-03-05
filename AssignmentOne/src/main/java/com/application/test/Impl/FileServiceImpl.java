package com.application.test.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.application.test.service.FileService;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public List<File> getAllFiles(String directoryPath)
	{
		File directory=new File(directoryPath);
		if(!directory.isDirectory()) {
			throw new IllegalArgumentException("Provided path is not in directory");
		}
		return Arrays.asList(directory.listFiles());
	}
}
