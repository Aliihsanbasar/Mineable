package com.mine.mineable.data.response;

import org.json.JSONObject;

import java.util.List;


public class CoinList {

    private List<JSONObject> coins;

    public List<JSONObject> getCoins() {
        return coins;
    }

    public void setCoins(List<JSONObject> coins) {
        this.coins = coins;
    }
}
