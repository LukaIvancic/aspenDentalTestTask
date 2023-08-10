package constants;

import org.apache.commons.lang3.RandomStringUtils;

public class Const {

    public static final String HEADER_ACCEPT = "application/vnd.github+json";
    public static final String X_GITHUB_API_VERSION = "2022-11-28";
    public static final String TOKEN = "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";
    public static final String INVALID_TOKEN = "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1";

    public static final String REPO = "/repArchived";
    public static final String NON_EXISTING_REPO = "rep";
    public static final String ALREADY_EXISTING_REPO_NAME = "Hello-World1";

    public static final String NEW_REPO_NAME = "Repo" + RandomStringUtils.randomAlphabetic(4);
    public static final String NEW_REPO_DESCRIPTION = "This is your first repo!";
    public static final String NEW_REPO_HOMEPAGE = "https://github.com";

    public static final String PATCH_REPO_NAME = "NewRepoName" + RandomStringUtils.randomAlphabetic(5);
    public static final String PATCH_REPO_DESCRIPTION = "Deskripshn";
    public static final String PATCH_NON_EXISTING_NAME = "asdffdsa";
    public static final String PATCH_DUPLICATE_NAME = "RepooGZz";


    //DeleteTestErrors
    public static final String DELETE_ERROR_MESSAGE = "Not Found";
    public static final String DELETE_DOCUMENTATION_URL = "https://docs.github.com/rest/repos/repos#delete-a-repository";




}
