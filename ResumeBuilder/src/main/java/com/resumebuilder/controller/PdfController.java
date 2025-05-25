package com.resumebuilder.controller;

import com.resumebuilder.dto.CompanyDto;
import com.resumebuilder.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @PostMapping
    public void createPdf(@RequestBody List<CompanyDto> companyDtos) throws FileNotFoundException {
        pdfService.createPdf(companyDtos);
    }
}
