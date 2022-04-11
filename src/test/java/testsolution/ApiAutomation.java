package testsolution;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApiAutomation {

    @DataProvider(name = "UserDataJson")
    public Object[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("users.json");

        Object obj = jsonParser.parse(reader);

        JSONObject createUserJsonobj = (JSONObject) obj;
        JSONArray createUserArray = (JSONArray) createUserJsonobj.get("users");

        String arr[] = new String[createUserArray.size()];

        for (int i = 0; i < createUserArray.size(); i++) {
            JSONObject user = (JSONObject) createUserArray.get(i);
            String nm = (String) user.get("name");
            String jb = (String) user.get("job");

            arr[i] = nm + "," + jb;
        }
        return arr;
    }

    @Test(dataProvider = "UserDataJson")
    public void createUserTest(String data) {

        String users[] = data.split(",");
        Map<String, Object> user = new HashMap<>();
        user.put("name", users[0]); //name
        user.put("job", users[1]);  //job


        ValidatableResponse response = given()
                .baseUri("https://reqres.in/api")
                .contentType(ContentType.JSON)
                .body(user)

                .when()
                .post("/users")

                .then()
                .assertThat().statusCode(201)
                .body("name", equalTo(user.get("name")))
                .body("job", equalTo(user.get("job")))
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS)
                .log().body();


    }
}
