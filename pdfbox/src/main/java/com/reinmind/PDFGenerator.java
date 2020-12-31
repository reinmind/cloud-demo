package com.reinmind;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;


public class PDFGenerator {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();

        for (int i = 0; i < 10; i++) {
            PDPage page = new PDPage();
            PDPageContentStream contentStream = new PDPageContentStream(document,page);
            //开始写入
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.newLineAtOffset(25,500);
            String text = "PDFBOX Test example";
            contentStream.showText(text);
            //结束写入
            contentStream.endText();
            contentStream.close();
            document.addPage(page);
        }
        document.save("/Users/xiang.zhang/Downloads/pdfbox_blank10.pdf");
        System.out.println("pdf generated");
        document.close();
    }
}
