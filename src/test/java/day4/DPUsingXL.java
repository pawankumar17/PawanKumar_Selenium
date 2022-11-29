package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DPUsingXL {
	@Test
	public void testdata() {
		File src= new File("./testData/SapientTestData.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sh1= wb.getSheet("DataSheet");
			XSSFRow r1= sh1.getRow(0);
			XSSFCell c1= r1.getCell(0);
			String username = c1.getStringCellValue();
			System.out.println(username);
			wb.close();
		} catch (FileNotFoundException e) {
			System.out.println("Please check data file path"+ e.getMessage());
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Somethinf Went Wrong"+ e.getMessage());
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

}
