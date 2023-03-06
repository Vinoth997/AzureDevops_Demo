package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleTest {
	
	WebDriver driver;
	
	@Test
	public void browserLaunch() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://nxtgenaiacademy.com/demo-site/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods = "browserLaunch")
	public void listAllLabels() {
		List<WebElement> labelList = driver.findElements(By.xpath("//label[@class='vfb-desc']"));
		for(int i=0;i<labelList.size();i++) {
			String labelText = labelList.get(i).getText();
			System.out.println(labelText);
		}
	}

}
