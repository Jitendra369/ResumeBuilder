package com.resumebuilder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sound.midi.VoiceStatus;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumebuilder.dto.Experience;
import com.resumebuilder.dto.Resume;
import com.resumebuilder.repo.ResumeRepo;

@Service
public class ResumeServiceImpl implements ResumeService{

	@Autowired
	private ResumeRepo resumeRepo;
	
	public Resume saveResume(Resume resume) {
		try {
			System.out.println("length of the summary is : " +resume.getSummary().length());
			List<Experience> experience = resume.getExperience();
			experience.stream().forEach(exp ->  System.out.println(exp.getDescription().length()));
			return resumeRepo.save(resume);	
		} catch (Exception e) {
			System.out.println("unable to save the resume object in DB ");
		}
		return null;
	}
	
	public List<Resume> getAllResumeFromDb(){
		List<Resume> allResumes = resumeRepo.findAll();
		if (CollectionUtils.isNotEmpty(allResumes)) {
			return allResumes;
		}
		System.out.println("no data found from DB");
		return new ArrayList<>();
	}

	@Override
	public Resume getResumeById(int id) {
		Optional<Resume> resumeOptional = resumeRepo.findById(id);
		if (resumeOptional.isPresent()) {
			return resumeOptional.get();
		}
		System.out.println("no data found from DB for id "+ id);
		return null;
	}

	@Override
	public Resume getResumeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resume> getResumeByExperience(int startYear, int endYear) {
		// TODO Auto-generated method stub
		return null;
	}
}
