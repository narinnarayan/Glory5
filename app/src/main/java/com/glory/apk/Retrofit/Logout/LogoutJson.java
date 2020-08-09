package com.glory.apk.Retrofit.Logout;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutJson {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("response")
    @Expose
    private Response response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}