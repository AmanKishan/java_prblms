package com.helpingduck.ratelimit.cache;

import java.util.UUID;

public class BaseEntity {

    private UUID id;

    public BaseEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
