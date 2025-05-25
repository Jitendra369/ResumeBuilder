package com.resumebuilder.service;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.resumebuilder.dto.CompanyDto;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Component;
import com.resumebuilder.dto.CompanyDto;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore.PrivateKeyEntry;

@Component
public class PdfService {

	private static final String path = "D:\\pdfOperation\\hello.pdf";
	private static final float MARGIN_TOP = 15f;
	private static final float MARGIN_LEFT = 15f;
	private static final float MARGIN_RIGHT = 15f;
	private static final float MARGIN_BOTTOM = 15f;
	private static final String companyInfor = "In 1947, the firm set up offices in Calcutta and Madras and New Delhi. In 1948, 55 acres of undeveloped marsh and jungle was acquired in Powai, Mumbai. In December 1950, L&T became a public company with a paid-up capital of ₹20 lakh (equivalent to ₹22 crore or US$2.6 million in 2023).";

	public void createPdf(java.util.List<CompanyDto>  companyDtos) throws FileNotFoundException {

		PdfWriter writer = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(writer);
		Document document = new Document(pdfDocument);
		document.setMargins(MARGIN_TOP, MARGIN_RIGHT, MARGIN_BOTTOM, MARGIN_LEFT);

//        createBasicPDF(path);
		boolean isFileLocationCreated = createFolderIfNotPresent(path);
//        createCanvasPdf(path);
		for (CompanyDto companyDto : companyDtos) {
			createTable(path, companyDto, document);
			document.add(new Paragraph(""));
		}
		
		
		document.close();
		try {
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	private void createTable(String destPath, CompanyDto companyDto, Document document) throws FileNotFoundException {

		float[] pointColoumnWidth = { 150f, 150f, 150f };
//        create a table of 2 column
//        Table table = new Table(UnitValue.createPercentArray(2));
		Table table = new Table(UnitValue.createPercentArray(new float[] { 30, 70 }));
		table.useAllAvailableWidth();
		table.setBorder(new SolidBorder(1));
		table.setWidth(UnitValue.createPercentValue(100));

		Cell headerCell = new Cell(1, 2).add(new Paragraph(companyDto.getCompanyName()))
				.setBackgroundColor(new DeviceRgb(209, 238, 154)) // #d1ee9a
				.setBold().setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER)
				.setBorder(new SolidBorder(1));

//        headerCell.setBackgroundColor(new DeviceRgb(209, 238, 154));
//        headerCell.setBold();
//        headerCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
//       #d1ee9a
//       #88ab44

		table.addHeaderCell(headerCell);

		Cell cell1 = createCell("Category : ", true, null, null);
//        cell1.setBorder(new SolidBorder(1));

		table.addCell(cell1);
		Cell cell2 = createCell(companyDto.getCategory(), true, null, null);
		table.addCell(cell2);

//        description row
		List list = new com.itextpdf.layout.element.List().setSymbolIndent(12).setListSymbol("\u2022").setFontSize(10);
		list.add(new ListItem(companyInfor));

		Cell cellDesc = new Cell(1, 2).add(list).setBorder(Border.NO_BORDER);

		cellDesc.setPadding(25f);
		cellDesc.setPaddingLeft(25f);
		table.addCell(cellDesc);

//        address cell 
		Cell addressCellKey = createCell("Address", true, null, null);
		Cell addressCellValue = createCell(companyDto.getAddress(), true, null, null);

		table.addCell(addressCellKey);
		table.addCell(addressCellValue);

//        phone number 
		Cell landlineCellKey = createCell("LandLine Number ", true, null, null);
		Cell landlineCellValue = createCell(companyDto.getPhoneNumbers().toString(), true, null, null);
		table.addCell(landlineCellKey);
		table.addCell(landlineCellValue);

//        company url 
		Cell webUrlCellKey = createCell("WebSite URL ", true, null, null);
		Cell webUrlCellValue = createCell(companyDto.getCompanyUrl(), true, null, null);
		table.addCell(webUrlCellKey);
		table.addCell(webUrlCellValue);

		document.add(table);
		
	}

	private Cell createCell(String name, boolean noBorder, Integer col1, Integer colSpan) {
		Cell cell = null;
		if (col1 != null && colSpan != null) {
			cell = new Cell(col1, colSpan);
		} else {
			cell = new Cell();
		}
		cell.add(new Paragraph(name));
		cell.setPadding(12f);

		if (noBorder) {
			cell.setBorder(Border.NO_BORDER);
		}
		return cell;
	}

	private void createCanvasPdf(String destinationPath) throws FileNotFoundException {
		PdfDocument pdf = new PdfDocument(new PdfWriter(destinationPath));
		PageSize pageSize = new PageSize(PageSize.A4.rotate());
		PdfPage pdfPage = pdf.addNewPage(pageSize);

		PdfCanvas pdfCanvas = new PdfCanvas(pdfPage);
//        drag the pointer to the center of the page
		pdfCanvas.concatMatrix(1, 0, 0, 1, pageSize.getWidth() / 2, pageSize.getHeight() / 2);
		drawCanvas(pdfCanvas, pageSize);

		pdf.close();

	}

	private void drawCanvas(PdfCanvas canvas, PageSize ps) {
		canvas.moveTo(-(ps.getWidth() / 2 - 15), 0).lineTo(ps.getWidth() / 2 - 15, 0).stroke();
	}

	private void createBasicPDF(String destinationPath) throws FileNotFoundException {
		PdfWriter pdfWriter = new PdfWriter(destinationPath);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		document.add(new Paragraph("Helllo world"));
		document.close();
	}

//    create the folder path , if folder path is not present
	private boolean createFolderIfNotPresent(String path) {
		boolean fileCreated = false;
		boolean pdfLocationCreated = false;
		File file = new File(path);
		if (!file.exists()) {
			pdfLocationCreated = file.getParentFile().mkdir();
			if (pdfLocationCreated) {
				System.out.println("file location is created at the location " + file.getParentFile());
			}
		}
		return pdfLocationCreated;
	}
}
