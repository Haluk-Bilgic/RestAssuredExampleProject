import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostMethods {

    @Test
    public void Requests() {

        baseURI="http://dummy.restapiexample.com/api/v1";
     double number=Math.random();
     given().param("name"," haluk")
             .param("lastname","bilgic")
             .param("age","27")
             .param("number",number)
             .post("/create")
             .then().statusCode(200).log().all();
    }
    @Test
    public  void Requests2(){
        baseURI="http://dummy.restapiexample.com/api/v1";
        JSONObject request=new JSONObject();
        request.put("name","mehmet");
        request.put("salary","30000");
        given().header("Content-Type","application/json")
               . contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("/create")
                .then().statusCode(200).log().body();
    }

}
