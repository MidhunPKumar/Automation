package runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import utilities.PropertiesSetup;

public class MyMainClass {

	private static void getTestDataFromExcel() throws IOException {
		//Property file and input file
		PropertiesSetup ps = new PropertiesSetup();
		FileInputStream is = new FileInputStream(new File("resources//mpk.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(is);
		HSSFSheet sh = wb.getSheetAt(0);

		System.out.println(ps.getPropertyFromConfig("d"));

		// looping status yes tetscases
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			if (sh.getRow(i).getCell(0).toString().equalsIgnoreCase("y")
					|| sh.getRow(i).getCell(0).toString().equalsIgnoreCase("yes")) {
				System.out.println(sh.getRow(i).getCell(1).toString() + " | " + sh.getRow(i).getCell(2).toString()
						+ " | " + sh.getRow(i).getCell(3).toString());
			}
		}
	}
}
