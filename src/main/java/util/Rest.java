package util;

import constants.Const;
import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.Header;

import java.util.Map;

import io.restassured.response.Response;

public class Rest {

//    public static Response get(Map<String, String> getLoginHeader, String repo){
//
//        return (Response) RestAssured.given()
//                .baseUri(Endpoints.BASE_URL)
//                .header((Header) getLoginHeader)
//                .when()
////                .get("/repos/" + owner + "/" + repo)
//                .get(Endpoints.REPOS + Endpoints.OWNER + repo)
//                .then()
//                .log().body()
//                .statusCode(200);
//    }

    public static Response getRepo(String repo, String accessToken){

        return RestAssured.given()
                .baseUri(Endpoints.BASE_URL)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(Endpoints.REPOS + Endpoints.OWNER + repo);

    }

    public static <T> Response postRepo(T body, String accessToken){

        return RestAssured.given()
                .header("Accept", Const.HEADER_ACCEPT)
                .header("Authorization", "Bearer " + accessToken)
                .header("X-GitHub-Api-Version", Const.X_GITHUB_API_VERSION)
                .baseUri(Endpoints.BASE_URL)
                .body(body)
                .log()
                .body()
                .when()
                .post(Endpoints.USER + Endpoints.REPOS);

    }

    public static Response deleteRepo(String repoName, String accessToken){

        return RestAssured.given()
                .header("Accept", Const.HEADER_ACCEPT)
                .header("Authorization", "Bearer " + accessToken)
                .header("X-GitHub-Api-Version", Const.X_GITHUB_API_VERSION)
                .baseUri(Endpoints.BASE_URL)
                .when()
                .delete(Endpoints.REPOS + Endpoints.OWNER + "/" + repoName);
    }

    public static <T> Response patchRepo(T body, String accessToken, String currentRepoName){

        return RestAssured.given()
                .header("Accept", Const.HEADER_ACCEPT)
                .header("Authorization", "Bearer " + accessToken)
                .header("X-GitHub-Api-Version", Const.X_GITHUB_API_VERSION)
                .baseUri(Endpoints.BASE_URL)
                .body(body)
                .log()
                .body()
                .when()
                .patch(Endpoints.REPOS + Endpoints.OWNER + "/" + currentRepoName);

    }

}
