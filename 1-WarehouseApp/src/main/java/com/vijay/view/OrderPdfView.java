package com.vijay.view;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vijay.model.Order;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderPdfView  extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "atttachment;filename=order.pdf");
		@SuppressWarnings("unchecked")
		List<Order> list=(List<Order>) model.get("list");
		Paragraph p=new Paragraph("Hello World");
		document.add(p);
		
		PdfPTable table=new PdfPTable(6);
		
		table.addCell(" ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("METHOD");
		table.addCell("ACCEPT");
		table.addCell("DESCRIPTION");
		
		for ( Order o:list)
		{
			table.addCell(o.getOrderId());
			table.addCell(o.getOrderMode());
			table.addCell(o.getOrderCode());
			table.addCell(o.getOrderMethod());
			table.addCell(o.getOrderAccept());
			table.addCell(o.getOrderDescription());
		}
		
		document.add(table);
	}
		
	}


