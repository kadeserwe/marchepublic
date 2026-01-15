package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
class DemoApplicationTests {


	public static void main(String[] args) throws IOException, InvalidFormatException {
		String output = "/Users/HP/Desktop/bjdoc/test.docx";
		// String output = "/Users/pankajjain/Downloads/test.docx";
		XWPFDocument document = new XWPFDocument();

		XWPFParagraph title = document.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun titleR = title.createRun();
		titleR.setText("Generate Word Document using Java");
		titleR.setColor("0B0301");
		titleR.setBold(true);
		titleR.setFontFamily("Courier");
		titleR.setFontSize(20);

		XWPFParagraph subTitle = document.createParagraph();
		subTitle.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun subR = subTitle.createRun();
		subR.setText("Apache POI: The Java API for Microsoft Documents");
		subR.setColor("751B07");
		subR.setFontFamily("Courier");
		subR.setFontSize(16);
		subR.setTextPosition(20);
		subR.setUnderline(UnderlinePatterns.DASH);

		XWPFParagraph image = document.createParagraph();
		image.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun imageR = image.createRun();
		imageR.setTextPosition(20);
		//Path imagePath = Paths.get("/Users/pankajjain/Downloads/","myimage.jpeg");
		Path imagePath = Paths.get("/Users/HP/Desktop/bjdoc/","lopoip3.PNG");
		//C:\Users\HP\Desktop\bjdoc
		imageR.addPicture(Files.newInputStream(imagePath),
				XWPFDocument.PICTURE_TYPE_JPEG,imagePath.getFileName().toString(),
				Units.toEMU(50),Units.toEMU(50));

		XWPFParagraph para1 = document.createParagraph();
		para1.setAlignment(ParagraphAlignment.BOTH);
		String paraText = "Apache POI makes it extremely easy to create or parse Microsoft office documents." +
				"It is a rich set of APIs which help with document creation and manipulation." +
				" This is an example of a paragraph created using Apache POI.";
		XWPFRun para1Run = para1.createRun();
		para1Run.setText(paraText);

		//create Table
		XWPFTable table = document.createTable();
		//create First row
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("Item Number");
		tableRowOne.addNewTableCell().setText("Item Name");
		tableRowOne.addNewTableCell().setText("Item Price");

		tableRowOne.getCell(0).setColor("272525");
		tableRowOne.getCell(1).setColor("272525");
		tableRowOne.getCell(2).setColor("272525");

		//create second row
		XWPFTableRow tableRowTwo = table.createRow();
		tableRowTwo.getCell(0).setText("1");
		tableRowTwo.getCell(1).setText("Chair");
		tableRowTwo.getCell(2).setText("10");

		//create third row
		XWPFTableRow tableRowThree = table.createRow();
		tableRowThree.getCell(0).setText("2");
		tableRowThree.getCell(1).setText("Table");
		tableRowThree.getCell(2).setText("20");

		//Write to file
		FileOutputStream out = new FileOutputStream(output);
		document.write(out);
		out.close();
		document.close();



	}

}
