package com.AspenDental;

import constants.Const;
import dto.request.PostRequestDTO;
import dto.response.ResponsePostDTO;
import dto.response.errors.DELETEerrorDTO;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Rest;

public class DeleteTest {

    @Test
    public void deleteRepo(){
        Response responsePost =
                Rest.postRepo(new PostRequestDTO(Const.NEW_REPO_NAME, Const.NEW_REPO_DESCRIPTION, Const.NEW_REPO_HOMEPAGE),
                        Const.TOKEN);
        ResponsePostDTO responsePostBody = responsePost.getBody().as(ResponsePostDTO.class);

        Response responseDelete =
                Rest.deleteRepo(responsePostBody.getName(), Const.TOKEN);
//        DELETEerrorDTO deletEerrorDTO = responseDelete.getBody().as(DELETEerrorDTO.class);

        Assert.assertEquals(responseDelete.getStatusCode(), 204);
//        Assert.assertEquals(deletEerrorDTO.getMessage(), Const.DELETE_ERROR_MESSAGE);
//        Assert.assertEquals(deletEerrorDTO.getDocumentationUrl(), Const.DELETE_DOCUMENTATION_URL);


    }

    //delete nonexisting

}
