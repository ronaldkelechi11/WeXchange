package com.wehub.wexchange.apiHelpers;

import com.wehub.wexchange.models.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitInterface {
    @POST("/signup")
    Call<Integer> executeSignup(@Body HashMap<String, String> map);

    @POST("/login")
    Call<User> executeLogin(@Body HashMap<String, String> map);
}
