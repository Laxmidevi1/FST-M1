package LiveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectGitHub {
    RequestSpecification requestSpec;
    String SSHkey;
    int id;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Authorization", "token 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")
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Test(priority = 1)
    public void postRequest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title", "IBMLAPTAP");
        reqBody.put("key", "SHA256:GE3Hg+ykn3U282bpR6QSfDTCdIHJxyUMz7faEGcNMOY");
        Response response = given().spec(requestSpec).body(reqBody).when().post();
        id = response.then().extract().path("id");
        SSHkey = response.then().extract().path("key");
        response.then().body("id", equalTo(id));
        response.then().body("key", equalTo(SSHkey));
        response.then().body("title", equalTo("TestAPIKey"));
        System.out.println(response.asPrettyString());
    }

    @Test(priority = 2)
    public void getRequest(){
        Response response = given().spec(requestSpec).pathParam("keyId", id).
                when().get("/{keyId}");
        response.then().body("id", equalTo(id));
        response.then().body("key", equalTo(SSHkey));
        response.then().body("title", equalTo("TestAPIKey"));
        System.out.println(response.asPrettyString());
    }

    @Test(priority = 3)
    public void deleteRequest(){
        Response response = given().spec(requestSpec).pathParam("keyId", id).
                when().delete("/{keyId}");
        System.out.println(response.asPrettyString());
    }
}
