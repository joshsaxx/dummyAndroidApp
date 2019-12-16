package com.example.mydummyproj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GitHubJobsApi {

    @Headers("Accept: application/json")
    @GET("positions.json?")
    Call<List<Jobs>> getJobs(@Query("search")String search);







}
