package StepDefenition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import Pojo.Location;
import Pojo.map;
import Resources.APIResoources;
import Resources.TestDataBuild;
import Resources.Utility;
import groovyjarjarantlr4.v4.misc.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Steps extends Utility {
	RequestSpecification req;
	ResponseSpecification resspec;
	RequestSpecification res;
	Response resp;
	TestDataBuild data=new TestDataBuild();
	String Place;

	@Given("add place api with {string} {string} and {string}")
	public void add_place_api_with_and(String name, String adress, String phonenum) throws IOException{

		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		res=given().spec(RequestSpec())
		.body(data.addPlace(name,adress,phonenum));
	}
	
	

@When("user calls {string} with {string} HTTP request")
public void user_calls_with_http_request(String resourceName, String method) {
	APIResoources resource=APIResoources.valueOf(resourceName);
	
	if(method.equalsIgnoreCase("POST"))
	{
		resp=res.when().post(resource.getResource()	).
				then().spec(resspec).extract().response();
	}
	if(method.equalsIgnoreCase("GET"))
	{
		resp=res.when().get(resource.getResource()	).
				then().spec(resspec).extract().response();
	}
	if(method.equalsIgnoreCase("DELETE"))
	{
		resp=res.when().delete(resource.getResource()	).
				then().spec(resspec).extract().response();
	}
}
	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
	   assertEquals(resp.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {

		assertEquals(getJsonPath(resp,key),value);
		

	}
	@Then("verify the place_id maps to the {string} using {string}")
	public void verify_the_place_id_maps_to_the_using(String name, String respo) throws IOException{
	    Place=	getJsonPath(resp,"place_id");
		res=given().spec(RequestSpec()).queryParam("place_id",Place);
		user_calls_with_http_request(respo,"GET");
		assertEquals(getJsonPath(resp,"phone_number"),name);
		
	}
	@Given("deletePlace Payload")
	public void delete_place_payload()  throws IOException{
		res=given().spec(RequestSpec()).queryParam("place_id",Place);
	}


}
