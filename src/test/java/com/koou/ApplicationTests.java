package com.koou;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author koou
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
		File file = new File("F:\\Projects\\pfangwang\\test.docx");
		String str = "";
		try {
			FileInputStream fis = new FileInputStream(file);
			XWPFDocument xdoc = new XWPFDocument(fis);
			XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
			String doc1 = extractor.getText();
			System.out.println(doc1);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
