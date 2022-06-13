package com.mine.mineable.data;


import com.mine.mineable.data.response.Coin;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("coins?")
    Call<List<Coin>> getCoins(@Query("list") String list);
}
