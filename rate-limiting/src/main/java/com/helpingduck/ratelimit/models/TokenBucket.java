package com.helpingduck.ratelimit.models;

public class TokenBucket {

    private Integer counter;
    private Long unixTimeStamp;

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Long getUnixTimeStamp() {
        return unixTimeStamp;
    }

    public void setUnixTimeStamp(Long unixTimeStamp) {
        this.unixTimeStamp = unixTimeStamp;
    }
}