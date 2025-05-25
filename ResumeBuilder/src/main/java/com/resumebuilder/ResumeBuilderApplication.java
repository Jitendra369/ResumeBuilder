package com.resumebuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resumebuilder.dto.CompanyDto;
import com.resumebuilder.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResumeBuilderApplication implements CommandLineRunner{

	
	@Autowired
	private PdfService pdfService;
	
	public static void main(String[] args) {
		SpringApplication.run(ResumeBuilderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String json = "{\n" +
                "  \"companyName\": \"Acme Corporation number 124454 \",\n" +
                "  \"category\": \"Technology\",\n" +
                "  \"address\": \"123 Innovation Drive, Silicon Valley, CA\",\n" +
                "  \"phoneNumbers\": [\n" +
                "    \"+1-800-123-4567\",\n" +
                "    \"+1-800-765-4321\"\n" +
                "  ],\n" +
                "  \"faxNumbers\": [\n" +
                "    \"+1-800-111-2222\"\n" +
                "  ],\n" +
                "  \"companyUrl\": \"https://www.acmecorp.com\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        CompanyDto company = objectMapper.readValue(json, CompanyDto.class);
        
        
//		pdfService.createPdf(company);
	}

}
