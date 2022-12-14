package day3;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	@Parameters("browser")
    @Test
    public void loginTest(String browser) {
        WebDriver driver=null;
        
        if(browser.equalsIgnoreCase("Chrome")) {
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox")) {
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        Assert.assertTrue(driver.getCurrentUrl().contains("orangehrm"));
        driver.quit();
        
    }
}
