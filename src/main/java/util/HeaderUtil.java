package util;


import constants.Const;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {

    public static Map<String, String> postRepoHeader (String authorizationToken){

        Map<String, String> header = new HashMap<>();
        header.put("Accept", Const.HEADER_ACCEPT);
        header.put("Authorization", authorizationToken);
        header.put("X-GitHub-Api-Version", Const.X_GITHUB_API_VERSION);
        return header;

    }

}
