package com.example.manisha.election;

import com.example.manisha.election.http.RetrofitApiService;

public class ApiUtil {

    private static final String BASE_URL = "http://www.mocky.io/";

    public static RetrofitApiService getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitApiService.class);
    }

}
