package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class PutPatchDeleteExamples {
@Test
public void testPut(){
    JSONObject request=new JSONObject();
    request.put("name","Haluk");
    request.put("job","Soldier");
    System.out.println(request);
   baseURI="https://reqres.in/api";
    given().
             header("Content-Type","application/json").
             contentType(ContentType.JSON).accept(ContentType.JSON).
                    body(request.toJSONString()).
            when().
            put("/users/2").
            then().
            statusCode(200).log().all();
}
    @Test
    public void testPatch(){
        JSONObject request=new JSONObject();
        request.put("name","Haluk");
        request.put("job","Soldier");
        System.out.println(request);
        baseURI="https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/2").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void testDelete(){
        baseURI="https://reqres.in/api";
        given().
                when().
                delete("/users/2").
                then().
                statusCode(204).log().all();

    }
@Test
    public  void  example(){

    given().queryParam("CUSTOMER_ID","68195")
            .queryParam("PASSWORD","1234!")
            .queryParam("Account_No","1")
            .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().statusCode(200).log()
            .body();
}

}
