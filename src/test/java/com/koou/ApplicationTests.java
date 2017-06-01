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
			String disc = doc1.substring(doc1.indexOf("区域对应板块：") + "区域对应板块：".length(), doc1.indexOf("地铁线路"));
			String subway = doc1.substring(doc1.indexOf("地铁线路") + "地铁线路".length(), doc1.indexOf("问题："));
			System.out.println(disc);
			System.out.println(subway);
			parse(disc.split("\n"));
			parse(subway.split("\n"));

			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void parse(String[] discArray) {
		for (int i = 0; i < discArray.length; i ++) {
			if (!discArray[i].equals("")) {
				System.out.println(discArray[i].substring(0, discArray[i].indexOf("：")));
				String[] disArrayJ = discArray[i].substring(discArray[i].indexOf("：") + 1).split(" ");
				for (int j = 0; j < disArrayJ.length; j++) {
					System.out.println(disArrayJ[j]);
				}
			}
		}
	}



}
