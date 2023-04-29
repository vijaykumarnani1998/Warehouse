package com.vijay.view;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vijay.model.Uom;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UomPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
     		
		response.addHeader("Content-Disposition", "atttachment;filename=vijay.pdf");
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>) model.get("list");
		Paragraph p=new Paragraph("Hello World");
		document.add(p);
		
		PdfPTable table=new PdfPTable(4);
		
		table.addCell("Uom ID");
		table.addCell("Uom Type");
		table.addCell("Uom Model");
		table.addCell("Uom Description");
		
		for (@SuppressWarnings("unused") Uom uom:list)
		{
			table.addCell(uom.getUomId());
			table.addCell(uom.getUomType());
			table.addCell(uom.getUomModel());
			table.addCell(uom.getUomDescription());
		}
		
		document.add(table);
	}

}
