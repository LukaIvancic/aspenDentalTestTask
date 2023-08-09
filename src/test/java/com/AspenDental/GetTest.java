package com.AspenDental;

import constants.Const;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Rest;

public class GetTest {

//    @Test
//    public void testReadRepository() {
//        String accessToken = "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";
//        String owner = "LukaIvancic";
//        String repo = "/rep1";
//
//        RestAssured.given()
//                .baseUri(Endpoints.BASE_URL)
//                .header("Authorization", "Bearer " + accessToken)
//                .when()
////                .get("/repos/" + owner + "/" + repo)
//                .get(Endpoints.REPOS + Endpoints.OWNER + repo)
//                .then()
//                .log().body()
//                .statusCode(200);
//    }

    @Test
    public void getRepoTest(){
        Response response =
                Rest.getRepo(Const.REPO, Const.TOKEN);

        Assert.assertEquals(response.getStatusCode(), 200);
//        ResponseDTO responseBody = response.getBody().as(ResponseDTO.class);
//        Assert.assertEquals(responseBody.getName(), "rep1"); naknadno


    }

    @Test
    public void getRepoTestNonExistant(){
        Response response =
                Rest.getRepo(Const.NON_EXISTING_REPO, Const.TOKEN);

        Assert.assertEquals(response.getStatusCode(), 404);


    }


}
