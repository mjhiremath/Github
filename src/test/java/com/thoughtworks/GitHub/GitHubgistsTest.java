package com.thoughtworks.GitHub;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubgistsTest {
	
	@Test
	public void creategist() {
		RestAssured.baseURI = "https://api.github.com";
        //Request
        RequestSpecification httprequest = RestAssured.given();
        //JSON body
        JSONObject requestParamter = new JSONObject();
        requestParamter.put("desciption","Created from API"); 
        requestParamter.put("public",true); 
        JSONObject requestParamter1 = new JSONObject();
        requestParamter.put("files",requestParamter1);
        JSONObject requestParamter2 = new JSONObject();
        requestParamter1.put("workshop.txt",requestParamter2);
        requestParamter2.put("content","Gist created from API");
        
        httprequest.header("Content-Type","application/json");
        httprequest.header("Authorization","Basic bWpoaXJlbWF0aDo3OWY1ZmI3MzU0MzgwODVjMzY1NzMxMWU4ZDQwYTg4MzMxMGNmOGQw");
        httprequest.body(requestParamter.toJSONString());
        
        Response response = httprequest.request(Method.POST,"/gists");
        int statusCode = response.getStatusCode();
        System.out.print("The Status code is " +statusCode);
        assertEquals(statusCode,201); 
        
        
  }
}