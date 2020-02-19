package com.thoughtworks.GitHub;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubnotificationTest {
	@Test
	public void getnotification() {
		RestAssured.baseURI = "https://api.github.com";
        //Request
        RequestSpecification httprequest = RestAssured.given();
         
        httprequest.header("Authorization","Basic bWpoaXJlbWF0aDo3OWY1ZmI3MzU0MzgwODVjMzY1NzMxMWU4ZDQwYTg4MzMxMGNmOGQw");
        
        //response
        Response response = httprequest.request(Method.GET,"/notifications");
        
        //Status code compare
        int statusCode = response.getStatusCode();
        System.out.print("The Status code is " +statusCode);
        assertEquals(200,statusCode); 
        
        //get the login details from response
        //JsonPath jsonPathEvaluator = response.jsonPath();
        String responseBody = response.body().asString();
        System.out.println(" Response body is " +responseBody);        

	}
	
	

}
