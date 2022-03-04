package get_https_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {
    @Test
    public void test04() {
        /*
http://dummy.restapiexample.com/api/v1/employees  url'ine
 GET request'i yolladigimda gelen response'un
 status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
 */
        String url = "http://dummy.restapiexample.com/api/v1/employees";

Response response=given().when().get(url);

response.prettyPrint();

        response.then().statusCode(200).contentType(ContentType.JSON).
                assertThat().body("data", Matchers.hasSize(24),// hassize data nin sayisi 24 mu list size gibi dusun
                        "data.employee_name",Matchers.hasItem("Ashton Cox"),//hasitem ise buna sahip mi
                        "data.employee_age",Matchers.hasItems(21,61,23));//hasitem S ise bunlara sahip mi en az biri
        // adeti karsilastırılacaka = Matchers.hasSizekullanılır
// bir deger aranacaksa = Matchers.hasItem kullanılır
// birden fazla deger aranacaksa = Matchers.hasItems kullanılır

    }
}