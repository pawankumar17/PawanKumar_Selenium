package day5;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Downloader {

	WebDriver d;
	ChromeOptions o= new ChromeOptions();
	@BeforeMethod
	public void setup() {

		d= new ChromeDriver();
		//		o.addArguments("start-maximized");
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod
	public void trdw() {
		d.quit();
	}
	@Test
	public void test() throws InterruptedException, IOException {
		d.get("https://the-internet.herokuapp.com/upload");
//		o.addArguments("start-maximize");
		Actions a =new Actions(d);
		a.moveToElement(d.findElement(By.id("file-upload"))).click().perform();
		Thread.sleep(1000);
//		d.findElement(By.id("file-upload")).click().perform();
		Runtime.getRuntime().exec("C://Users//pawkumar16//Downloads");
		d.findElement(By.id("file-submit")).click();
       
	}


}