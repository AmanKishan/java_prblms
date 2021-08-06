package com.helpingduck.ratelimit.exception;

public class RateLimiterException extends Exception{

    private String message;

    public RateLimiterException(String message) {
        super(message);
        this.message = message;
    }


    @Override
    public String toString() {
        return ("Rate Limiter Exception Occurred : " +this.message);
    }
}
