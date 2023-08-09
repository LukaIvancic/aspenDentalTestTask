
package dto.response.errors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DELETEerrorDTO {
    @JsonProperty
    @SerializedName("documentation_url")
    private String mDocumentationUrl;
    @JsonProperty
    @SerializedName("message")
    private String mMessage;

    public String getDocumentationUrl() {
        return mDocumentationUrl;
    }

    public void setDocumentationUrl(String documentationUrl) {
        mDocumentationUrl = documentationUrl;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

}
