package get_https_request.day07;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest16 extends JsonPlaceHolderBaseUrl {
      /*
   https://jsonplaceholder.typicode.com/todos/7
   {
   "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false
}
    */

    @Test
    public void test16(){
        //1)URL OLUSTURMA

        spec04.pathParams("bir","todos","iki","7");

        //2)EXPECTED DATA OLUSTUR

        Map<String,Object> expectedData=new HashMap<>();

        expectedData.put("userId",1);
        expectedData.put("id",7);
        expectedData.put("title","illo expedita consequatur quia in");
        expectedData.put("completed",false);

        System.out.println("EXPECTED DATA:" +expectedData);

        //REQUEST VE RESPONSE

    Response response=    given().spec(spec04).when().get("/{bir}/{iki}");

        // "/{bir}/{iki}" --> adrese ekleme yapmak

//response.prettyPrint();

        //DATAYI JSON'DAN -> JAVAYA De-Serialization

        //DATAYI JAVA'DAN  -> JSON'A Serialization

        //Niçin bu değişim yapmaya gerek duyarsın
        //Expected ve actual dataları karsılastırma yapmak ıcın aynı formatta olması gerekır
        // Bunun ıcın dataları aynı ture cevırmemız gerekır

        Map<String, Object> actualData=response.as(HashMap.class);  //De-Serialization

        System.out.println("ACTUAL DATA: "+actualData);

        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));


    }

}
