package com.resumebuilder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumebuilder.dto.Resume;

@Repository
public interface ResumeRepo  extends JpaRepository<Resume,Integer>{

}
