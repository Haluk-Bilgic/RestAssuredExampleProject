import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class GetWorks {
    Response response=null;
    @Test
public  void test(){
    response=RestAssured.given().when().get("https://samples.openweathermap.org/");
     response.then().statusCode(200).log().all();
}
@Test
    public void test1(){
        response=RestAssured.given().when().get("https://rickandmortyapi.com/api/character/1");
        JsonPath js=response.jsonPath();
        String name=js.get("name");
        System.out.println(name);
}
    @Test
    public void test2(){
        response=RestAssured.given().when().get("https://rickandmortyapi.com/api/character");
        JsonPath js=response.jsonPath();
        List<String> list=js.get("results.name");
        System.out.println(list);
//her iki yolda olur.İkiside aynısı.
        List<String> list2=RestAssured.given().when().get("https://rickandmortyapi.com/api/character")
                .then().extract().jsonPath()
                .getList("results.name");
        System.out.println(list2);
    }
@Test
    public void test3(){
    response = RestAssured.given().when().get("http://dummy.restapiexample.com/api/v1/employees");
    JsonPath js = response.jsonPath();
    String Name = js.get("data.employee_name[1]");
    String Id =js.get("data.id[1]");
    System.out.println("Response  : " + response.asString());
    System.out.println("Status code : " + response.getStatusCode());
    System.out.println("Name:"+Name);
    System.out.println("id: "+Id);
    Assert.assertEquals(response.getStatusCode(), 200);
}
@Test
    public void test4(){
        response=RestAssured.given().pathParam("id",2).when()
        .get("https://rickandmortyapi.com/api/character/{id}");
       response.then().log().body();
}
@Test
    public void test5(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        response=RestAssured.given().when().get("/users");
    ResponseBody body=response.getBody();
    String bodyAsString=body.asString();
    Assert.assertTrue(bodyAsString.contains("Ervin Howell"));
    System.out.println(bodyAsString);
}

}
