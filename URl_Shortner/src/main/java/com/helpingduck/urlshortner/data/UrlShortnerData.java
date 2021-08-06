package com.helpingduck.urlshortner.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class UrlShortnerData {

    public static Map<Long,String> idUrlMap = new ConcurrentHashMap<>();

    private UrlShortnerData(){
    }
}