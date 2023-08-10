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
    public void patchRepoTest() {

        Response responsePost =
                Rest.postRepo(new PostRequestDTO(Const.NEW_REPO_NAME, Const.NEW_REPO_DESCRIPTION, Const.NEW_REPO_HOMEPAGE),
                        Const.TOKEN);
        ResponsePostDTO responsePostBody = responsePost.getBody().as(ResponsePostDTO.class);

        Response responsePatch =
                Rest.patchRepo(new PatchRequestDTO(Const.PATCH_REPO_NAME, Const.PATCH_REPO_DESCRIPTION),
                        Const.TOKEN, responsePostBody.getName());

        Assert.assertEquals(responsePatch.getStatusCode(), 200);


    }

    @Test
    public void patchNonExistingRepo() {
        Response responsePatch =
                Rest.patchRepo(new PatchRequestDTO(Const.PATCH_REPO_NAME, Const.PATCH_REPO_DESCRIPTION),
                        Const.TOKEN, Const.PATCH_NON_EXISTING_NAME);

        Assert.assertEquals(responsePatch.getStatusCode(),404);

    }


// Flaky test i thought i managed to reproduce 307 status code, but i was clearly wrong. Did work couple of times though
//    @Test
//    public void patchRepoTemporaryRedirect() {
//        Response responsePatch =
//                Rest.patchRepo(new PatchRequestDTO(Const.ALREADY_EXISTING_REPO_NAME, Const.PATCH_REPO_DESCRIPTION),
//                        Const.TOKEN, Const.ALREADY_EXISTING_REPO_NAME);
//
//        Assert.assertEquals(responsePatch.getStatusCode(),307);
//
//    }


    @Test
    public void patchAlreadyExistingNameRepo() {
        Response responsePatch =
                Rest.patchRepo(new PatchRequestDTO(Const.PATCH_DUPLICATE_NAME, Const.PATCH_REPO_DESCRIPTION),
                        Const.TOKEN, Const.ALREADY_EXISTING_REPO_NAME);

        Assert.assertEquals(responsePatch.getStatusCode(),422);

    }


}
