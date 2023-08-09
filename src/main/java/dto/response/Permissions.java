
package dto.response;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permissions {

    @SerializedName("admin")
    private Boolean mAdmin;
    @SerializedName("maintain")
    private Boolean mMaintain;
    @SerializedName("pull")
    private Boolean mPull;
    @SerializedName("push")
    private Boolean mPush;
    @SerializedName("triage")
    private Boolean mTriage;

    public Boolean getAdmin() {
        return mAdmin;
    }

    public void setAdmin(Boolean admin) {
        mAdmin = admin;
    }

    public Boolean getMaintain() {
        return mMaintain;
    }

    public void setMaintain(Boolean maintain) {
        mMaintain = maintain;
    }

    public Boolean getPull() {
        return mPull;
    }

    public void setPull(Boolean pull) {
        mPull = pull;
    }

    public Boolean getPush() {
        return mPush;
    }

    public void setPush(Boolean push) {
        mPush = push;
    }

    public Boolean getTriage() {
        return mTriage;
    }

    public void setTriage(Boolean triage) {
        mTriage = triage;
    }

}
