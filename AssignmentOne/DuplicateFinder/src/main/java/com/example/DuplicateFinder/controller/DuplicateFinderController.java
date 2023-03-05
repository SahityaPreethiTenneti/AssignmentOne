package com.example.DuplicateFinder.controller;

import com.example.DuplicateFinder.service.DuplicateFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/duplicate-finder")
public class DuplicateFinderController {
    @Autowired
    DuplicateFinderService service;

    @GetMapping("/find-duplicates")
    public List<String> findDuplicates(@RequestParam String directoryPath) throws IOException {
        return service.findDuplicateFiles(directoryPath);
    }
}
