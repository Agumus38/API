package get_https_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 {

    @Test
    public void test06() {
        //https://restful-booker.herokuapp.com/booking/5 url’ine
        //accept type’i “application/json” olan GET request’i yolladigimda
        //gelen response’un

        //status kodunun 200
        //ve content type’inin “application/json”
        //ve firstname’in “Jim”
        //ve totalprice’in 600
        //ve checkin date’in 2015-06-12"oldugunu test edin
        String url = "https://restful-booker.herokuapp.com/booking/4";
        Response response = given().when().get(url);
        response.prettyPeek();
        response.prettyPrint();
        // response.then().contentType("application/json") .statusCode(200);//.assertThat().body()
// bu user silinmis
    }
}