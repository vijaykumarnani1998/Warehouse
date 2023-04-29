package com.vijay.view;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.vijay.model.Order;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("Content-Disposition", "attachment;filename=order.xlsx");
		@SuppressWarnings("unchecked")
		List<Order> list=(List<Order>) model.get("list");
		Sheet sheet=workbook.createSheet("order");
		setHeader(sheet);
		setBody(sheet,list);
		
		
				
	}
	private void setHeader(Sheet sheet) {
		
	Row row=sheet.createRow(0)	;
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("MODE");
	row.createCell(2).setCellValue("CODE");
	row.createCell(3).setCellValue("METHOD");
	row.createCell(4).setCellValue("ACCEPT");
	row.createCell(5).setCellValue("DESCRIPTION");
	}

	private void setBody(Sheet sheet, List<Order> list) {
		int i=1;
		for(Order o:list)
		{
		Row row=sheet.createRow(i++);
	row.createCell(0).setCellValue(o.getOrderId());
	row.createCell(1).setCellValue(o.getOrderMode());
	row.createCell(2).setCellValue(o.getOrderCode());
	row.createCell(3).setCellValue(o.getOrderMethod());
	row.createCell(4).setCellValue(o.getOrderAccept());
	row.createCell(5).setCellValue(o.getOrderDescription());
	}

	
}
}
