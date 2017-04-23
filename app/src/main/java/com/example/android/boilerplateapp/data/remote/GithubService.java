package com.example.android.boilerplateapp.data.remote;

import com.example.android.boilerplateapp.data.model.Event;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by yuanyou.
 */

public interface GithubService {

    @GET("events")
    Observable<List<Event>> getPublicEvents(@Query("page") int page);

    @GET
    Observable<List<Event>> getPublicEventsPaginate(@Url String url);
}
