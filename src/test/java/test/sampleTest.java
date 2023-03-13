package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void browserLaunch() throws MalformedURLException {
		
		int port = 4444;
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:" + port);
		options.addArguments("headless");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("http://nxtgenaiacademy.com/demo-site/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void listAllLabels() {
		List<WebElement> labelList = driver.findElements(By.xpath("//label[@class='vfb-desc']"));
		for(int i=0;i<labelList.size();i++) {
			String labelText = labelList.get(i).getText();
			System.out.println(labelText);
		}
	}
	
	@AfterTest
	public void browserQuit() {
		driver.quit();
	}
}
