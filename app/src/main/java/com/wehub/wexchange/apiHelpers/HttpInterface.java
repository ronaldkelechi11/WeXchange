package com.wehub.wexchange.apiHelpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpInterface {
    private static Retrofit retrofit;
    private static HttpInterface httpInterface;
    private static final String apiUrlTest = "http://10.0.2.2:3000";
    private static final String apiUrlLive = "";

    private HttpInterface(){
        retrofit = new Retrofit.Builder().baseUrl(apiUrlTest).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static HttpInterface getInstance(){
        if(httpInterface == null){
            httpInterface = new HttpInterface();
        }
        return httpInterface;
    }

    public RetrofitInterface getApi(){
        return retrofit.create(RetrofitInterface.class);
    }
}
