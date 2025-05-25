package com.resumebuilder.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resumebuilder.dto.Resume;
import com.resumebuilder.service.ResumeBuilderService;
import com.resumebuilder.service.ResumeServiceImpl;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	
	@Autowired
	private ResumeServiceImpl resumeService;
	
	@Autowired
	private ResumeBuilderService resumeBuilderService;
	
	@PostMapping("/save")
	public Resume saveResume(@RequestBody Resume resume) {
		return resumeService.saveResume(resume);
	}
	
	@GetMapping("/view/{id}")
	public Resume getResume(@PathVariable int id) {
		return resumeService.getResumeById(id);
	}
	
	@GetMapping("/view/all")
	public List<Resume> getAllResumeDetails(){
		return resumeService.getAllResumeFromDb();
	}
	
	@GetMapping("/create")
	public void createResume() throws IOException {
		resumeBuilderService.createResumeFromData();
	}
}
