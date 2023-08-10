package com.AspenDental;
import constants.Const;
import dto.request.PostRequestDTO;
import dto.response.ResponsePostDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Rest;


public class PostTest {

    @Test
    public void postRepoTest(){

        Response response =
                Rest.postRepo(new PostRequestDTO(Const.NEW_REPO_NAME, Const.NEW_REPO_DESCRIPTION, Const.NEW_REPO_HOMEPAGE),
                        Const.TOKEN);
        Assert.assertEquals(response.getStatusCode(), 201);

        ResponsePostDTO responseBody = response.getBody().as(ResponsePostDTO.class);
        Assert.assertEquals(responseBody.getName(),Const.NEW_REPO_NAME );
        Assert.assertEquals(responseBody.getDescription(), Const.NEW_REPO_DESCRIPTION);
        Assert.assertEquals(responseBody.getHomepage(),Const.NEW_REPO_HOMEPAGE);
    }


    @Test
    public void postExistingRepoTest(){

        Response response =
                Rest.postRepo(new PostRequestDTO(Const.ALREADY_EXISTING_REPO_NAME, Const.NEW_REPO_DESCRIPTION, Const.NEW_REPO_HOMEPAGE),
                        Const.TOKEN);
        Assert.assertEquals(response.getStatusCode(), 422);



    }

    @Test
    public void postRepoUnprocessableRequestTest() {

        Response response =
                Rest.postRepo(new PostRequestDTO("","",""),
                        Const.TOKEN);
        Assert.assertEquals(response.getStatusCode(), 422);

    }

    @Test
    public void postRepoBadRequestTest() {

        Response response =
                Rest.postRepo(new PostRequestDTO(),
                        Const.TOKEN);
        Assert.assertEquals(response.getStatusCode(), 422);

    }

    @Test
    public void postRepoUnauthorizedTest() {

        Response response =
                Rest.postRepo(new PostRequestDTO(Const.ALREADY_EXISTING_REPO_NAME, Const.NEW_REPO_DESCRIPTION, Const.NEW_REPO_HOMEPAGE),
                        Const.INVALID_TOKEN);
        Assert.assertEquals(response.getStatusCode(), 401);

    }

}
