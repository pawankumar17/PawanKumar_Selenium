package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleDynamicElements {
@Test
//	public static void main(String[] args) {
	public void test8() {
		
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		d.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		d.get("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		Assert.assertTrue(d.getCurrentUrl().contains("blogspot"));
//		250ms
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.findElement(By.xpath("//input [@name= 'fname']")).sendKeys("Sapient");
		d.findElement(By.xpath("//input [@value= 'Show me']")).click();
		
		WebDriverWait wait= new WebDriverWait(d, Duration.ofSeconds(20));
		
		WebElement e= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id= 'passnew']")));
		e.sendKeys("Pawan");
//		d.quit();
		
		

	}

}
