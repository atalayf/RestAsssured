package mySeleniumProjectsRestAssured;
import org.json.simple.JSONObject;
	import org.testng.Assert;

		import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class RESTAssuredPOSTRequest {

		@Test

		void RESTAssuredPOST() {
			// Specify base URI
			RestAssured.baseURI = "http://restapi.demoqa.com/customer";
			// Request Object
			RequestSpecification httpRequest = RestAssured.given();
		
			//Request payload sending along with post request
			
			
		
			
			JSONObject requestParams=new JSONObject();
// Her calistirildiginda buradaki data degistirilmeli. yoksa username catistigi zaman hata veriyor.
			
			requestParams.put("FirstName", "Joe");
			requestParams.put("LastName", "Brown");
			requestParams.put("UserName", "BrownJd");
			requestParams.put("Password", "jonh123d");
			requestParams.put("Email", "jonhd@gmailcom");
	
			httpRequest.header("Content-Type","application/json");
			
			httpRequest.body(requestParams.toJSONString()); // Attach above data to the request
			
			
			// Response object
			
			Response response = httpRequest.request(Method.POST, "/register");
			
			// print response in console window.

			String responseBody = response.getBody().asString();

			System.out.println("Response Body is: " + responseBody);
			
			

			// Status Code Validation

			int statusCode = response.getStatusCode();

			System.out.println("Status Code is: " + statusCode);
			Assert.assertEquals(statusCode, 201);

			String successCode=response.jsonPath().get("SuccessCode");
			
			Assert.assertEquals(successCode, "OPERATION_SUCCESS");
			

		}


}
