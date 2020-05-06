package mySeleniumProjectsRestAssured;

import org.testng.Assert;

//import static io.restassured.RestAssured.delete;
//import static io.restassured.RestAssured.get;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.hasItems;

//import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import groovyjarjarasm.asm.commons.Method;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTAssuredGET {

	final static String ROOT_URI = "http://restapi.demoqa.com/utilities/weatherfull/city/ankara";

	String[] cities = { "/Ankara", "/Bursa", "/Adana" };
	public String city;
	
	
	@Test
	
	void myCityLoop() {
	
	for (int i = 0; i < cities.length; i++) {
		city=cities[i];
		getWeatherDetails(city);
	}
	
	}
	

	void getWeatherDetails(String city) {
		// Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weatherfull/city";
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		// Response object

			Response response = httpRequest.request(Method.GET, city);

			// print response in console window.

			String responseBody = response.getBody().asString();

			System.out.println("Response Body is: " + responseBody);

			// Status Code Validation

			int statusCode = response.getStatusCode();

			System.out.println("Status Code is: " + statusCode);
			Assert.assertEquals(statusCode, 200);

			// Status Line Verification
			String statusLine = response.getStatusLine();
			System.out.println("status Line is: " + statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
