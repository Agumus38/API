package get_https_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {
    @Test
    public void test03(){
     /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Sally"
ve lastname'in "Ericsson"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */
String url="https://restful-booker.herokuapp.com/booking/7";
Response response=given().when().get(url);
response.prettyPrint();
response.then().contentType(ContentType.JSON).statusCode(200);

        response.then().assertThat().statusCode(200).contentType("application/json").
                body("firstname", equalTo("Mary"),
                        "lastname",equalTo("Wilson"),
                        "bookingdates.checkin",equalTo("2016-01-03"),"bookingdates.checkout"
                        ,equalTo("2016-12-30"));

    }
}
