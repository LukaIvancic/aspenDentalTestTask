package com.AspenDental;

import constants.Const;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Rest;

public class GetTest {


    @Test
    public void getRepoTest(){
        Response response =
                Rest.getRepo(Const.REPO, Const.TOKEN);

        Assert.assertEquals(response.getStatusCode(), 200);



    }

    @Test
    public void getRepoTestNonExisting(){
        Response response =
                Rest.getRepo(Const.NON_EXISTING_REPO, Const.TOKEN);

        Assert.assertEquals(response.getStatusCode(), 404);

    }

    @Test
    public void getRepoInvalidToken(){

        Response response =
                Rest.getRepo(Const.REPO, Const.INVALID_TOKEN);

        Assert.assertEquals(response.getStatusCode(), 401);

    }

}
