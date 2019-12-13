package com.example.mydummyproj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GitHubJobsApi {

    @Headers("Accept: application/json")
    @GET("positions.json?search=node")
    Call<List<Jobs>> getJobs();







}
