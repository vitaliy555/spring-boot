package com.spring.boot.view_resolvers;


import org.apache.commons.codec.binary.Base64;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.io.SaveToZipFile;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Document;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DocxView extends AbstractTemplateView {

    public DocxView() {
        setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model,
                                             HttpServletRequest request, HttpServletResponse response) throws Exception {

        WordprocessingMLPackage wordMLPackage =
                WordprocessingMLPackage.load(getApplicationContext().getResource(getUrl()).getFile());

        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        org.docx4j.wml.Document wmlDocumentEl = (org.docx4j.wml.Document) documentPart.getJaxbElement();
        String xml = XmlUtils.marshaltoString(wmlDocumentEl, true);

        HashMap<String, String> mappings = new HashMap<String, String>();
        for (Object key : model.keySet()) {
            mappings.put(key.toString(), model.get(key).toString());
        }

        Object obj = XmlUtils.unmarshallFromTemplate(xml, mappings);
        documentPart.setJaxbElement((Document) obj);

        String name = model.get("filename")+".docx";

        response.setHeader("Content-Disposition", "attachment" + name);

        ServletOutputStream out = response.getOutputStream();
        (new SaveToZipFile(wordMLPackage)).save(out);

        out.flush();

    }

    public boolean checkResource(Locale locale) {
        return getApplicationContext().getResource(getUrl()).exists();
    }

}

