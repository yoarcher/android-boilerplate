package com.example.android.boilerplateapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by yuanyou.
 */

public class Event {

    @SerializedName("id")
    String id;

    @SerializedName("actor")
    Actor actor;

    @SerializedName("repo")
    Repo repo;

    @SerializedName("created_at")
    Date createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }
}
