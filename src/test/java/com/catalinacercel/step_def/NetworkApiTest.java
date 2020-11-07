package com.catalinacercel.step_def;

import com.catalinacercel.apiModels.Network;
import com.catalinacercel.apiModels.Networks;
import java.util.*;
import com.catalinacercel.utils.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;

public class NetworkApiTest {

    Response response;
    ValidatableResponse validatableResponse;

    @When("I send  the request to networks")
    public void iSendTheRequestToNetworks() {
        response = RestAssured.given().get(Constants.BASE_URI);
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        validatableResponse = response.then().statusCode(statusCode);
    }

    @And("response includes the following city {string}")
    public void responseIncludesTheFollowingCity(String city, DataTable dataTable) {
        Map<String,String> data = dataTable.asMap(String.class,String.class);

        Networks networks = response.as(Networks.class);

        for(Network network : networks.getNetworks()){
            if(network.getLocation().getCity().equals(city)){

                assertThat(network.getLocation().getCountry(),equalTo(data.get("country")));
                assertThat(network.getLocation().getLatitude(),equalTo(Double.valueOf(data.get("latitude"))));
                assertThat(network.getLocation().getLongitude(),equalTo(Double.valueOf(data.get("longitude"))));
            }
        }
    }


    @And("I validate the Json Schema is correct")
    public void iValidateTheJsonSchemaIsCorrect() {
        assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("networks.json"));
    }

}
