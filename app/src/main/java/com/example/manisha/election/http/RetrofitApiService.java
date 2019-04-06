package com.example.manisha.election.http;

import com.example.manisha.election.models.Polling;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {
    @GET("v2/5ca8b5d0520000582697b809")
    Call<List<Polling>> getPollingData();
}
