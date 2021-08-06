package com.helpingduck.ratelimit;

import com.helpingduck.ratelimit.cache.BaseEntity;
import com.helpingduck.ratelimit.common.RequestType;
import com.helpingduck.ratelimit.exception.RateLimiterException;
import com.helpingduck.ratelimit.models.User;
import com.helpingduck.ratelimit.strategy.TokenBucketingStrategy;

import java.util.Stack;

public class TokenBucketContext {

    private TokenBucketingStrategy tokenBucketingStrategy;

    public TokenBucketContext(TokenBucketingStrategy tokenBucketingStrategy) {
        this.tokenBucketingStrategy = tokenBucketingStrategy;
    }

    public boolean isRequestProcessed(BaseEntity entity) throws  RateLimiterException {
        return this.tokenBucketingStrategy.isRequestProcessed(entity);
    }

    public static void main(String[] args) {
        TokenBucketingStrategy tokenBucketingStrategy = new TokenBucketingStrategy(1, RequestType.SECOND,5);
        TokenBucketContext tokenBucketContext = new TokenBucketContext(tokenBucketingStrategy);
        User user = new User("aman");
        try{
            for(int i =0 ;i < 10;i++){

                System.out.println("Request " + i + " processed stated " +  tokenBucketContext.isRequestProcessed(user));
                Thread.sleep(1);
            }

        }catch (RateLimiterException | InterruptedException e){
            System.err.println("Error Occurred " + e.getMessage());
        }

        Stack<Integer> stk = new Stack<>();

    }
}
