package day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstSeleniumScript4 {

//	public static void main(String[] args) throws InterruptedException {
	@Test
	public void test3() throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Assert.assertTrue(driver.getCurrentUrl().contains("ineuron"));
		driver.findElement(By.linkText("New user? Signup")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).sendKeys("Pawan Kumar");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("Pawan@gmail.com");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]")).sendKeys("11342662883");
//		Thread.sleep(10000);
//		WebElement label= driver.findElement(By.xpath("//label[contains(text(),'Pawan Kumar')]"));
//		label.click();
////		Thread.sleep(3000);
//		WebElement gender = driver.findElement(By.xpath("//input[text()= 'Male']"));
//				gender.click();
//		
//		WebElement stateDropdown= driver.findElement(By.id("state"));
//		Select state= new Select(stateDropdown);
//		state.selectByIndex(2);
////		Thread.sleep(2000);
//		state.selectByVisibleText("Goa");
////		Thread.sleep(2000);
//		state.selectByVisibleText("Karnataka");
//		List<WebElement> allValues=state.getOptions();
//		
//		for(WebElement ele : allValues) {
//			if(ele.getText().equalsIgnoreCase("Rajasthan")) {
//				break;
//			}
//			System.out.println(ele.getText());
//		}
//		 driver.findElement(By.xpath("//button[text()='Sign up']")).click();
//		driver.findElement(By.xpath())
		
		
//		Thread.sleep(1000);
//		driver
//		stateDropdown= driver.findElement(By.)
		

	}

}
