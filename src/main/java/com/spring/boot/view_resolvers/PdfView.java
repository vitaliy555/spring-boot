package com.spring.boot.view_resolvers;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by vitaliy on 12.10.16.
 */
public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, String> revenueData = (Map<String, String>) map.get("revenueData");
        Table table = new Table(2);
        table.addCell("Month");
        table.addCell("Revenue");
        for (Map.Entry<String, String> entry : revenueData.entrySet()) {
            table.addCell(entry.getKey());
            table.addCell(entry.getValue());
        }
        document.add(table);
    }
}
