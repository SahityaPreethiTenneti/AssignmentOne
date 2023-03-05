package com.application.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssessmentController {

	private final AssessmentService assessmentService;
	
	public AssessmentController(AssessmentService assessmentService)
	{
		this.assessmentService=assessmentService;
	}
	
	@GetMapping("/assessment")
	public ResponseEntity<Map<String,List<String>>> runAssesment(@RequestParam String folderPath)
	{
		Map<String,List<String>> assessmentResult=assessmentService.runAssessment(folderPath);
		
		List<String> duplicates=new ArrayList<>();
		for(List<String> fileList:assessmentResult.values()) {
			for(String fileName:fileList) {
				duplicates.add(fileName);
			}
		}
		
		if(duplicates.isEmpty()) {
			return ResponseEntity.ok(assessmentResult);
		}
		
		Map<String,List<String>> responseMap=new HashMap<>();
		responseMap.put("duplicates",duplicates);
		return ResponseEntity.ok(responseMap);
	}
	
	
}
