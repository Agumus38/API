package testAPIs;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q4_9 extends DummyBaseUrl {


    /*
        http://dummy.restapiexample.com/api/v1/employee/12 URL'E GiT.
        1) Matcher CLASS ile
        2) JsonPath ile dogrulayin.

    */

    @Test
    public void test09(){

spec02.pathParams("first","api","second","v1"
,"third","employee","forth","12");

Response response=given().spec(spec02).when().get("/{first}/{second}/{third}/{forth}");

 response.prettyPeek();

//json path

        JsonPath json=response.jsonPath();
        System.out.println(json.toString());
     //   List<Integer> idList=json.getList("data.id");
     //   System.out.println(idList.size());

      //  assertEquals("Quinn Flynn",json.getString("data[11].employee_name"));
       // assertEquals( 342000,json.getInt("data[11].employee_salary"));
       // assertEquals(22,json.getInt("data[11].employee_age"));


// de-serialization ile

        HashMap<String , Object> actualData= response.as(HashMap.class);
        System.out.println("actualdataMap: "+ actualData);

       assertEquals(
               ( (Map)(       actualData.get("data"))).get("employee_name"),
               "Quinn Flynn");






    }










}
