package IntertrustTestAutomation;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.hamcrest.core.IsEqual.*;

public class APITest {
  @Test
  public void verifyGetRequest() {
	  
	  given()
	 
	  .when()
	    .get(RestAssured.baseURI)
	  .then()
	    .statusCode(200)
	    .body("address",equalTo("Pune"))
	    .body("timezone", equalTo("Asia/Kolkata"))
	    .body("resolvedAddress",equalTo("Pune, MH, India"));
	  
	 
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	 
	        RestAssured.baseURI = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Pune?unitGroup=metric&key=55NATTAVJFZY6P2S62S8LPMCL&contentType=json";
	  
  }

 

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
