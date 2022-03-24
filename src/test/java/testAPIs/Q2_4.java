package testAPIs;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Q2_4 {
     /*
    http://dummy.restapiexample.com/api/v1/employees  url'ine
    GET request'i yolladigimda gelen response'un
    status kodunun 200 ve content type'inin "application/json"
    ve employees sayisinin 24
    ve employee'lerden birinin "Ashton Cox"
    ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
    */

    @Test

    public void test04() {

String url="http://dummy.restapiexample.com/api/v1/employees";

Response response=given().when().get(url);
response.prettyPrint();

response.then().contentType(ContentType.JSON).statusCode(200);

response.then().assertThat().body("data",hasSize(24),
        "data.employee_name",hasItem("Ashton Cox"),
        "data.employee_age",hasItems(21,61,23));

        HashMap<String , Object> actualData=response.as(HashMap.class);
        System.out.println("actualdata"+actualData.get("id")+"actualData");




    }


}
