package com.resumebuilder.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumebuilder.dto.Resume;

@Service
public class ResumeBuilderService {

	@Autowired
	private PdfService pdfService;
	
	@Autowired
	private ResumeService resumeService;
	
	
	public void createResumeFromData() throws IOException {
		int id =  1;  // under development 
		if (id < 0) {
			System.out.println("invalid id , not resume data found against the id "+ id);
			return;
		}else {
			Resume resume = resumeService.getResumeById(id);
			if (null != resume) {
				System.out.println("creating the resume for id "+ id);
				try {
					pdfService.buildResume(resume);
				} catch (FileNotFoundException e) {
					System.out.println("exception while creating the document");
					e.printStackTrace();
				}	
				System.out.println("resume pdf has been created for the id "+ id);
			}
		}
	}
}
