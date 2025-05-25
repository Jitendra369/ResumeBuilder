package com.resumebuilder.dto;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;


@Embeddable
public class Education {
	 private String date;
     private String degree;
     private String minor;
     private String institution;
     private String gpa;
     
     @ElementCollection
     @CollectionTable(name = "eduction_higlight", joinColumns = @JoinColumn(name = "resume_id"))
     private List<String> highlights;
     
	public Education() {
		super();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public List<String> getHighlights() {
		return highlights;
	}
	public void setHighlights(List<String> highlights) {
		this.highlights = highlights;
	}
     
     
}
