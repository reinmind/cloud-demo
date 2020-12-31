package com.reinmind.generator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TableGenerator {

    private static final Logger logger = LoggerFactory.getLogger(TableGenerator.class);
    private static final String path = "/Users/xiang.zhang/Downloads/itexttable3.pdf";
    private static final String fontName = "STSong-Light";
    private static final String fontPath = "/Users/xiang.zhang/workspace/font/MSYHBbold.ttf";
    private Font font = null;

    public TableGenerator() {
        this.font = getFont();
    }

    public Font getFont() {
        BaseFont zh = null;
        try {
            zh = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            logger.error("获取字体失败:{}", fontPath);
        }
        return new Font(zh, 14);
    }

    public void generate() throws FileNotFoundException {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
        } catch (DocumentException e) {
            logger.error("获取PdfWriter实例失败");
        }
        logger.info("获取pdf成功");

        document.open();
        try {
            document.add(new Phrase("本pdf仅供参考", font));
        } catch (DocumentException e) {
            logger.error("添加文字失败");
        }
        PdfPTable table = new PdfPTable(3);
        addTableHeader(table);
        addRows(table);
        try {
            addCustomRows(table);
        } catch (Exception e) {
            logger.error("添加自定义表格失败");
        }
        try {
            document.add(table);
            logger.info("添加表格成功");
        } catch (DocumentException e) {
            logger.error("向文档添加表格失败");
        }

        document.close();
        logger.info("成功生成PDF:{}", path);
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("第一列", "第二列", "第三列")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle, font));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table) {
        table.addCell(new Phrase("行1, 列1", font));
        table.addCell(new Phrase("行1, 列2", font));
        table.addCell(new Phrase("行1, 列3", font));
    }

    private void addCustomRows(PdfPTable table)
            throws URISyntaxException, BadElementException, IOException {
        Path path = null;
        String pngpath = "/Users/xiang.zhang/IdeaProjects/cloud-demo/itextpdf/src/main/resources/javalogo.png";
        try {
            path = Paths.get(ClassLoader.getSystemResource(pngpath).toURI());
        } catch (Exception e) {
            logger.info("获取图片路径失败:{}",path);
        }
//        Image img = Image.getInstance(path.toAbsolutePath().toString());
        Image img = Image.getInstance(pngpath);
        img.scalePercent(10);

        PdfPCell imageCell = new PdfPCell(img);
        table.addCell(imageCell);

        PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
        horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(horizontalAlignCell);

        PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
        verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(verticalAlignCell);
        logger.info("添加自定义表格成功");
    }
}
