package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver= new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	@Test(dataProvider = "test1")
	public void test2(String username, String password) {
		
		//		Assert.assertTrue(driver.getCurrentUrl().contains("ineuron"));
		driver.findElement(By.name("email1")).sendKeys(username);
		//		username.sendKeys("SapientTraining@gmail.com");
//		Assert.assertTrue();
		driver.findElement(By.id("password1")).sendKeys(password);;
		driver.findElement(By.className("submit-btn")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()= 'Sign out']")).isDisplayed());
		driver.findElement(By.xpath("//button[text()= 'Sign out']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2 [text()='Sign In']")).isDisplayed());


	}
//	@DataProvider(name ="testdata")
//	public Object[][] testDataGeneration(){
//		Object [][]arr= new Object[4][2];
//
////		arr[0][0]=
//				arr[0][0]= "sample9@gmail.com";
//				arr[0][1]="Mukesh1234";
//				arr[1][0]="samplemukesh@gmail.com";
//				arr[1][1]="Mukesh1234";
//				arr[2][0]="samplemukesh1@gmail.com";
//				arr[2][1]="Mukesh1234";
//				arr[3][0]="samplemukesh2@gmail.com";
//				arr[3][1]="Mukesh1234";
//
//				return arr;
//
//				
				
//	}
	@DataProvider(name= "test1")
	public Object testDataGeneration(){
		Object[][] arr= null;
//		File src= new File("C:\\Users\\Pawan\\Desktop\\Selenium\\Data.xlsx");
		try {
			
//			FileInputStream fis= ;
			XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(new File("./testData/SapientTestData.xlsx")));
//			XSSFSheet sh1= wb.getSheet("DataSheet");
//			XSSFRow r1= sh1.getRow(0);
//			XSSFCell c1= r1.getCell(0);
//			String username = c1.getStringCellValue();
			int row= wb.getSheet("DataSheet").getPhysicalNumberOfRows();
			int col= wb.getSheet("DataSheet").getRow(0).getPhysicalNumberOfCells();
			
			arr= new Object[row][col];
			
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					arr[i][j]= wb.getSheet("DataSheet").getRow(i).getCell(j).getStringCellValue();
				}
			}
//			System.out.println(username);
			wb.close();
			return arr;
		} catch (FileNotFoundException e) {
			System.out.println("Please check data file path"+ e.getMessage());
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Somethinf Went Wrong"+ e.getMessage());
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		String s= "Data was not taken from this method";
		return s;
		
		
	}


}
