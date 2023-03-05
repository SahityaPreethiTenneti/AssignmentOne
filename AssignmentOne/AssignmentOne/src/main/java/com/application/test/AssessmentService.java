package com.application.test;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface AssessmentService {

	Map<String,List<String>> runAssessment(String folderPath);
}
