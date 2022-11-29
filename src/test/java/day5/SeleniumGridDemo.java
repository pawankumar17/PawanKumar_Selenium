package day5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridDemo {
	
	WebDriver d;
	@Parameters({"browserName","browserVersion","os","osVersion"})
	
	@BeforeMethod
	public void setup(String bn, String bv, String oss,String os1){
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", bn);
		capabilities.setCapability("browserVersion", bv);
//		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		capabilities.setCapability("os", oss);
		capabilities.setCapability("osVersion", os1);
//		browserstackOptions.put("projectName", "Demo");
//		browserstackOptions.put("buildName", "Demo1.0");
//		browserstackOptions.put("sessionName", "Login test");
//		browserstackOptions.put("local", "false");
//		browserstackOptions.put("seleniumVersion", "3.5.2");
//		capabilities.setCapability("bstack:options", browserstackOptions);
		
		URL url= null;
		try {
			url=new URL("https://pawankumar_zi8SUX:mKKwxQt5e8szN2zeaqPy@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d = new RemoteWebDriver(url, capabilities);
	}
	@AfterMethod
	public void teardown() {
		d.quit();
	}
	
	@Test
	public void test() {
		d.get("https://ineuron-courses.vercel.app/login");
		Assert.assertEquals(d.getCurrentUrl().contains("ineuron"), true);
	}

}
