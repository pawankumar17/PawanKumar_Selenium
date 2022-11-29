package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice {
	  @Test
	    public void test() throws InterruptedException {
	        WebDriver driver= new ChromeDriver();
	    
	        driver.get("https://selectorshub.com/xpath-practice-page/");
	        Thread.sleep(2000);
	        driver.findElement(By.id("kils")).sendKeys("abc");
	    }
}
