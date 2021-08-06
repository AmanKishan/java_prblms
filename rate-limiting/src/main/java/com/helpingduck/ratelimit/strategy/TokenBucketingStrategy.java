package com.helpingduck.ratelimit.strategy;

import com.helpingduck.ratelimit.cache.BaseEntity;
import com.helpingduck.ratelimit.cache.Storage;
import com.helpingduck.ratelimit.common.RequestType;
import com.helpingduck.ratelimit.exception.RateLimiterException;
import com.helpingduck.ratelimit.models.TokenBucket;

import java.time.Instant;
import java.util.Objects;

public class TokenBucketingStrategy {

    private Integer time;
    private RequestType timeType;
    private Integer calculatedTime;
    private Integer initCounter;

    public TokenBucketingStrategy(final Integer time, final RequestType timeType, final Integer initCounter) {
        this.time = time;
        this.timeType = timeType;
        this.initCounter = initCounter;
        this.calculatedTime = this.getCalculatedTime();

    }

    public boolean isRequestProcessed(final BaseEntity entity) throws RateLimiterException {

        TokenBucket tokenBucket = this.fetchToken(entity);

            if(Objects.isNull(tokenBucket)){

                tokenBucket = new TokenBucket();
                tokenBucket.setCounter(this.initCounter-1);
                tokenBucket.setUnixTimeStamp(Instant.now().getEpochSecond());
                this.updateToken(entity,tokenBucket);
                return true;
            }
            System.out.println("------" + tokenBucket.getCounter());
            long timeDiff = Instant.now().getEpochSecond() - tokenBucket.getUnixTimeStamp();

            if(tokenBucket.getCounter() == 0){
                if(timeDiff <= this.calculatedTime){
                    throw new RateLimiterException("User id: " + entity.getId());
                }else{
                    tokenBucket.setCounter(this.initCounter-1);
                    tokenBucket.setUnixTimeStamp(Instant.now().getEpochSecond());
                    this.updateToken(entity,tokenBucket);
                    return true;
                }
            }

            if(timeDiff <= this.calculatedTime){
                tokenBucket.setCounter(tokenBucket.getCounter()-1);
                tokenBucket.setUnixTimeStamp(Instant.now().getEpochSecond());
                this.updateToken(entity,tokenBucket);
                return true;
            }else{
                tokenBucket.setCounter(this.initCounter-1);
                tokenBucket.setUnixTimeStamp(Instant.now().getEpochSecond());
                this.updateToken(entity,tokenBucket);
                return true;
            }

    }

    private TokenBucket fetchToken(BaseEntity entity){
        return Storage.getTokenBucketCache(entity);
    }

    private void updateToken(BaseEntity entity,TokenBucket tokenBucket){
        Storage.updateTokenBucketCache(entity,tokenBucket);
    }

    private Integer getCalculatedTime(){
        if(Objects.equals(this.timeType.name(), RequestType.MIN.name())){
            return this.time * 60;
        }else if(Objects.equals(this.timeType.name(), RequestType.HOUR.name())){
            return this.time * 60 * 60;
        }
        return this.time;
    }
}
