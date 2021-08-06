package com.helpingduck.ratelimit.models;

import com.helpingduck.ratelimit.cache.BaseEntity;

import java.util.UUID;

public class User extends BaseEntity {

    private String name;

    public User(String name) {
        super(UUID.randomUUID());
        this.name = name;
    }
}
