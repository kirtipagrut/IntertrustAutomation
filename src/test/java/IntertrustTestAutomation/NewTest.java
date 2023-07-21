package IntertrustTestAutomation;


import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.time.Duration;
import java.util.List;



public class NewTest  {
	  WebDriver driver;
	  String City="Pune";
  @Test
  public void VerifyWeatherForecastForCity() throws InterruptedException {
	  
	    WebElement WeatherData= 	driver.findElement(By.linkText("Weather Data"));
		WebElement cookies= driver.findElement(By.xpath("//button[text()='Accept all cookies']"));
		
		Actions actions = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(70));
		
		
		Thread.sleep(3000);
		cookies.click();
		Thread.sleep(3000);
		WeatherData.click();
		Thread.sleep(3000);
		WebElement location=driver.findElement(By.xpath("//form[@id='wxdataform']//input[@id=\"wxlocation\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("wxlocation")));
		actions.moveToElement(location); 
		actions.click();
		Thread.sleep(3000);
		location.sendKeys(City);
		Thread.sleep(5000);
		WebElement SearchButton = driver.findElement(By.xpath("//button[text()='Search']"));
		SearchButton.click();
		
		// Verified weather data for particular city is displayed .
		String title =driver.getTitle();
		System.out.println(title);
	   String ExpectedTitle ="Pune";
	   Assert.assertTrue(title.contains(ExpectedTitle));
	   Thread.sleep(3000);
	   
	   //Verified table data with id and city is displayed 
	   WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped fs-xs']"));
	   
	   List<WebElement> rows = table.findElements(By.xpath("//table[@class='table table-striped fs-xs']//tbody/tr"));
		int num_rows = rows.size();
		System.out.println("number of rows are"+num_rows);
		List<WebElement> col = table.findElements(By.tagName("th"));
		int num_col = col.size();
		System.out.println("numer of column are"+num_col);
		for(int i=1;i<=num_rows;i++)
		{
			for(int j=1;j<num_col;j++)
			{
				String cityStation= driver.findElement(By.xpath("//table[@class='table table-striped fs-xs']//tr["+i+"]//td["+j+"]")).getText();
				String id= driver.findElement(By.xpath("//table[@class='table table-striped fs-xs']//tr["+i+"]//td["+(j+1)+"]")).getText();
				
				if(cityStation.equals("PUNE, IN")&& id.equals("43063099999"))
				{	
				System.out.println(cityStation +" Station is present in Location and station map");
				System.out.println(id +" id is present for perticular location");
				break;
				}
				
		    }
			
			
			
		}
		
	  
  }
  @BeforeMethod
  public void launchBrowser() {
	
	  System.setProperty("driver.chrome.driver", "C:\\Users\\Admin\\3D Objects\\chromedriver_win32(1)\\chromedriver.exe");
	  driver = new ChromeDriver();
      driver.get("https://www.visualcrossing.com");
      driver.manage().window().maximize();
      
  }


  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
