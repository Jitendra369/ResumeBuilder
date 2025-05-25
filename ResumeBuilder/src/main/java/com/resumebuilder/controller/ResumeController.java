package com.resumebuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resumebuilder.dto.Resume;
import com.resumebuilder.service.ResumeServiceImpl;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	
	@Autowired
	private ResumeServiceImpl resumeService;
	
	@PostMapping("/save")
	public Resume saveResume(@RequestBody Resume resume) {
		return resumeService.saveResume(resume);
	}
}
