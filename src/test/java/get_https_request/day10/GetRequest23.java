package get_https_request.day10;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.*;

import static io.restassured.RestAssured.given;
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;
import static org.junit.Assert.assertEquals;

public class GetRequest23 extends DummyBaseUrl {
       /*
   http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
   Status kodun 200 olduğunu,
   14. Çalışan isminin "Haley Kennedy" olduğunu,
   Çalışan sayısının 24 olduğunu,
   Sondan 3. çalışanın maaşının 675000 olduğunu
   40,21 ve 19 yaslarında çalışanlar olup olmadığını
   10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi
   {
           "id": 10,
           "employee_name": "Sonya Frost",
           "employee_salary": 103600,
           "employee_age": 23,
           "profile_image": ""
    }
     olduğunu test edin.
   */

@Test
    public void test23(){
    //URL OLUSTUR

    spec02.pathParams("bir", "api", "iki", "v1","uc","employees");

    //EXPECTED DATA OLUSTUR

    DummyTestData expectedObje=new DummyTestData();
    HashMap<String , Object> expectedTestDataMap=expectedObje.setUpTestData();
    System.out.println("expected test data: "+expectedTestDataMap);

    //REQUEST VE RESPONSE

    Response response = given().spec(spec02).when().get("/{bir}/{iki}/{uc}");

    //DOGRULAMA
    //De-Serialization
    HashMap<String , Object> actualDataMap = response.as(HashMap.class);
    System.out.println("ActualDataMap: "+actualDataMap);

    //Status code un 200
    assertEquals(expectedTestDataMap.get("statusCode"),response.getStatusCode());

    // 14. Çalışan isminin "Haley Kennedy" olduğunu

assertEquals(expectedTestDataMap.get("ondorduncucalisan"),
        ((Map)((List)actualDataMap.get("data")).get(13)).get("employee_name"));

    //   Çalışan sayısının 24 olduğunu
    assertEquals(expectedTestDataMap.get("calisansayisi"),
            ((List<?>)actualDataMap.get("data")).size());

    //   Sondan 3. çalışanın maaşının 675000 olduğunu
    Assert.assertEquals(expectedTestDataMap.get("sondanucuncucalisanmaasi"),
            ((Map)((List)actualDataMap.get("data")).get(((List)actualDataMap.
                    get("data")).size()-3)).get("employee_salary"));

    //2.yol

    int dataSize=((List)actualDataMap.get("data")).size();

    assertEquals(expectedTestDataMap.get("sondanucuncucalisanmaasi"),
            ((Map)((List) actualDataMap.get("data")).get(dataSize-3)).get("employee_salary"));

    //   40,21 ve 19 yaslarında çalışanlar olup olmadığını
    //1. Yol
    List<Integer> actualYasListesi = new ArrayList<>();

    for(int i =0; i<dataSize; i++){
        actualYasListesi.add(((Integer) ((Map)((List<?>) actualDataMap.get("data")).get(i)).get("employee_age")));
    }
    System.out.println("actualYasListesi = " + actualYasListesi);

    Assert.assertTrue(actualYasListesi.containsAll((Collection<?>) expectedTestDataMap.get("arananyaslar")));

    //10. CALISANIN BiLGiLERiNi
        /*
        {"id": 10,
               "employee_name": "Sonya Frost",
               "employee_salary": 103600,
               "employee_age": 23,
               "profile_image": ""}
        */

    Assert.assertEquals(((Map) expectedTestDataMap.get("onuncucalisan")).get("employee_name"),
            ((Map)((List) actualDataMap.get("data")).get(9)).get("employee_name"));

    Assert.assertEquals(((Map) expectedTestDataMap.get("onuncucalisan")).get("employee_salary"),
            ((Map)((List) actualDataMap.get("data")).get(9)).get("employee_salary"));

    Assert.assertEquals(((Map) expectedTestDataMap.get("onuncucalisan")).get("employee_age"),
            ((Map)((List) actualDataMap.get("data")).get(9)).get("employee_age"));

    Assert.assertEquals(((Map) expectedTestDataMap.get("onuncucalisan")).get("profile_image"),
            ((Map)((List) actualDataMap.get("data")).get(9)).get("profile_image"));


}


}
