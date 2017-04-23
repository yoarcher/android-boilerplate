package com.example.android.boilerplateapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yuanyou.
 */

public class Actor {

    @SerializedName("id")
    String id;

    @SerializedName("display_login")
    String displayLogin;

    @SerializedName("avatar_url")
    String avatarUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayLogin() {
        return displayLogin;
    }

    public void setDisplayLogin(String displayLogin) {
        this.displayLogin = displayLogin;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
