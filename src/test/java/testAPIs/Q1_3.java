package testAPIs;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class Q1_3 {

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

    @Test
    public void test01(){
        String url="https://restful-booker.herokuapp.com/booking/7";
        Response response=given().when().get(url);

       // response.prettyPrint();
        response.prettyPeek();
       // response.then().log().all();

        response.then().statusCode(200).contentType("application/json");
        System.out.println(response.then().assertThat().body("bookingdates", Matchers.hasSize(2)));


                //status kodunun 200
        //ve content type'inin "application/json"
        //ve firstname'in "Sally"
        //ve lastname'in "Ericsson"
        //ve checkin date'in 2018-10-07"
        //ve checkout date'in 2020-09-30 oldugunu test edin
response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
        body("firstname",equalTo("Jim"),"lastname",equalTo("Ericsson")
        ,"bookingdates.checkin",equalTo("2019-02-04"));

//Json path

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(jsonPath.getString("firstname"),"Jim");

        HashMap<String , Object> actualData=response.as(HashMap.class);

        System.out.println(actualData.toString());
        response.then().assertThat().body("firstname",not("Armut"));
        Assert.assertEquals(actualData.get("firstname"),"Jim");




    }

}
