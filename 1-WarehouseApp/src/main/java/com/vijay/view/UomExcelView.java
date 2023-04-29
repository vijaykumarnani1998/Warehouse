package com.vijay.view;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.vijay.model.Uom;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UomExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=Uom.xlsx");
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>) model.get("list");
		
		Sheet sheet=workbook.createSheet("Uom");
		setHeader(sheet);
		setBody(sheet,list);
				
	}
	private void setHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("Uom ID");
		row.createCell(1).setCellValue("Uom Type");
		row.createCell(2).setCellValue("Uom Model");
		row.createCell(3).setCellValue("Uom Description");
		
	}

	private void setBody(Sheet sheet, List<Uom> list) {
		 int r=1;
		 for(Uom uom:list)
		 {
			 Row row=sheet.createRow(r++);
				row.createCell(0).setCellValue("uom.getUomId()");
				row.createCell(1).setCellValue("uom.getUomType()");
				row.createCell(2).setCellValue("uom.getUomModel");
				row.createCell(3).setCellValue("uom.getUomDescription");
		 }
	}



}
