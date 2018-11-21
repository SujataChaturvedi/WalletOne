package com.kryptoblocks.walletone.verification.network;

import com.google.gson.annotations.SerializedName;

public class TokenServerResponse {

    @SerializedName("jwt_token")
    private String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
