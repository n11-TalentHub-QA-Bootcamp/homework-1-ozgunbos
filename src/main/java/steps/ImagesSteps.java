package steps;
import filter.CustomLogFilter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
public class ImagesSteps {

    String key;
    int initialVoteCount=-1;

    Response response;
    CustomLogFilter customLogFilter ;




    @Given("x-api-key and baseURI already acquired.")
    public void x_api_key_and_base_uri_already_acquired() {
        key = "8adf71fc-c27b-40ef-8662-19ab891129e3";
        baseURI = "https://api.thedogapi.com/v1/";
        customLogFilter = new CustomLogFilter();
    }

    @When("User lists favourite image by {string}")
    public void user_lists_favourite_image_by(String sub_id) {
        // Write code here that turns the phrase above into concrete actions
        response = given().headers("x-api-key",key)
                .accept(ContentType.JSON)
                .pathParam("sub_id",sub_id)
                .when()
                .get("favourites?sub_id={sub_id}")
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Then("User should see his-her image {string}")
    public void user_should_see_his_her_image(String image_id) throws NoSuchFieldException {
        ObjectMapper mapper = new ObjectMapper();
        var actualValue = image_id;
        List voteList = response.getBody().jsonPath().get();

        //var checkImage =  voteList.get(voteList.size() -1 );
        List checkImage = voteList.subList(voteList.size()-1, voteList.size());

        //checkImage.stream().filter(p -> ).findAny().orElse(null);


        //JSONArray jArray = checkImage.getJSONArray("image_id");
//        List<List<String>> stuff = new ArrayList<List<String>>();
//        stuff.addAll(checkImage);

        //System.out.println(stuff.get(0));



    }
}
