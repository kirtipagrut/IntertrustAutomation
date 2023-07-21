package UITestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisualCrossing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	WebDriver driver;
	 
	 
	}
	
	
	void openBrowser(WebDriver driver)
	{
		System.setProperty("driver.chrome.driver", "C:\\Users\\Admin\\3D Objects\\chromedriver_win32(1)\\chromedriver.exe");
		  driver = new ChromeDriver();
	}
	
	
	void closeBrowser(WebDriver driver)
	
	{
		driver.close();
	}

	void launchURL(WebDriver driver)
	
	{
		
		driver.get("https://www.visualcrossing.com");
	}
	
	void VerifyWeatherForecastForCity(WebDriver driver)
	
	{
		
	WebElement WeatherData= 	driver.findElement(By.linkText("Weather Data"));
	WebElement location =	driver.findElement(By.id("wxlocation"));
	WebElement SearchButton = driver.findElement(By.xpath("//button[text()='Search']"));
	
	
	}
}
