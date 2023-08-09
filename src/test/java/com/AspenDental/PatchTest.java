package com.AspenDental;

import constants.Const;
import dto.request.PatchRequestDTO;
import dto.request.PostRequestDTO;
import dto.response.ResponsePostDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Rest;

public class PatchTest {

    @Test
    public void putRepoTest() throws InterruptedException {

        Response responsePost =
                Rest.postRepo(new PostRequestDTO(Const.NEW_REPO_NAME, Const.NEW_REPO_DESCRIPTION, Const.NEW_REPO_HOMEPAGE),
                        Const.TOKEN);
        ResponsePostDTO responsePostBody = responsePost.getBody().as(ResponsePostDTO.class);
        Thread.sleep(10000);
        Response responsePatch =
                Rest.patchRepo(new PatchRequestDTO(Const.PATCH_REPO_NAME, Const.PATCH_REPO_DESCRIPTION),
                        Const.TOKEN, responsePostBody.getName());

        Assert.assertEquals(responsePatch.getStatusCode(), 200);


    }

}
