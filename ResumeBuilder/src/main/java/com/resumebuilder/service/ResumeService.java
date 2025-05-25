package com.resumebuilder.service;

import java.util.List;

import com.resumebuilder.dto.Resume;

public interface ResumeService {

	public Resume saveResume(Resume resume);
	public List<Resume> getAllResumeFromDb();
	public Resume getResumeById(int id);
	public Resume getResumeByName(String name);
	public List<Resume> getResumeByExperience(int startYear, int endYear);
}
