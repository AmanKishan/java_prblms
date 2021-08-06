package com.helpingduck.ratelimit.cache;

import com.helpingduck.ratelimit.models.TokenBucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Storage {

    private Storage(){}

    private static final Map<BaseEntity, TokenBucket> TOKEN_BUCKET_CACHE;

    static {
        TOKEN_BUCKET_CACHE = new ConcurrentHashMap<>();
    }

    public static TokenBucket getTokenBucketCache(BaseEntity entity){
        return TOKEN_BUCKET_CACHE.get(entity);
    }

    public static void updateTokenBucketCache(BaseEntity entity, TokenBucket tokenBucket){
         TOKEN_BUCKET_CACHE.put(entity,tokenBucket);
    }
}
