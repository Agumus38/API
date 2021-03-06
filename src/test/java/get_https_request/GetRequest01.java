package get_https_request;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01(){
        String url="https://restful-booker.herokuapp.com/booking";
        Response response=given().when().get(url);
        System.out.println("status code: "+response.statusCode());
        System.out.println("content type: "+response.contentType());
        System.out.println("test zamanı: "+response.time());
        System.out.println("Status Line: "+response.statusLine());




        Assert.assertEquals(200,response.statusCode());
Assert.assertEquals("application/json; charset=utf-8",response.contentType());
response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8");
    }

}
