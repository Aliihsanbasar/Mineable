package com.mine.mineable.data.response;

public class Coin {

    private String id;
    private String coin;
    private String name;
    private String type;
    private String algorithm;
    private double network_hashrate;
    private double difficulty;
    //private long reward;
    private String reward_unit;
    private double price;
    private double volume;
    private long updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public double getNetwork_hashrate() {
        return network_hashrate;
    }

    public void setNetwork_hashrate(double network_hashrate) {
        this.network_hashrate = network_hashrate;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

//    public long getReward() {
//        return reward;
//    }
//
//    public void setReward(long reward) {
//        this.reward = reward;
//    }

    public String getReward_unit() {
        return reward_unit;
    }

    public void setReward_unit(String reward_unit) {
        this.reward_unit = reward_unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }
}
