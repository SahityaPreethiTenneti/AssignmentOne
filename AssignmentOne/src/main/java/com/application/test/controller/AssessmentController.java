package com.application.test.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.test.service.AssessmentService;

//import com.application.test.AssessmentService;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {

	private final AssessmentService assessmentService;
	
	public AssessmentController(AssessmentService assessmentService)
	{
		this.assessmentService=assessmentService;
	}
	
	@GetMapping("/duplicates")
	public ResponseEntity<List<String>> getDuplicateFileNames(@RequestParam String directoryPath)
	{
		try {
			List<String> duplicates=assessmentService.findDuplicateFileNames(directoryPath);
			if(duplicates.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(duplicates);
			}
		}
		catch(IllegalArgumentException e)
		{
			return ResponseEntity.badRequest().body(Collections.singletonList(e.getMessage()));
		}
	}
	
	
}
