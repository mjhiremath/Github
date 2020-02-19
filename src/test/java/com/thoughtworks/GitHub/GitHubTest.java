package com.thoughtworks.GitHub;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubTest {
    
    @Test
    public void getUser()
    {
    	 RestAssured.baseURI = "https://api.github.com";
         //Request
         RequestSpecification httprequest = RestAssured.given();
      
         //response
         Response response = httprequest.request(Method.GET,"/search/users?q=twqablore");
         
         //get the login details from response
         JsonPath jsonPathEvaluator = response.jsonPath();
         String user= jsonPathEvaluator.get("items[0].login");
         System.out.println("Login id is " +user);
         
         //compare the login
         Assert.assertEquals(user, "twqablore");
         
        //Status code compare
         int code = response.getStatusCode();
         System.out.print("The Status code is "+code);
         Assert.assertEquals(200, code); 
    }
    
}