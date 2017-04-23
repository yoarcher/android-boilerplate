package com.example.android.boilerplateapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yuanyou.
 */

public class Repo {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
