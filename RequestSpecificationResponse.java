package otherTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestSpecificationResponse {

    @Test
    public void  test(){

        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RequestSpecification httpRequest=RestAssured.given();

        Response response=httpRequest.request(Method.GET,"/booking");

        String responseBody=response.getBody().asString();
        System.out.println("Response Body:"+responseBody);
        Assert.assertEquals(responseBody.contains("bookingid"),true);
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getList("bookingid"));

        int statusCode=response.statusCode();
        System.out.println("Status Code:"+statusCode);
        Assert.assertEquals(statusCode,200);

        String statusLine=response.getStatusLine();
        System.out.println("Status Line:"+statusLine);

        String header=response.header("content-type");
        System.out.println("Content type:"+header);
        Assert.assertEquals(header,"application/json; charset=utf-8");

        System.out.println("****************************");

        Headers headers=response.headers();
        for(Header allheader:headers){
System.out.println(allheader.getName()+"     "+allheader.getValue());
        }
    }

}
