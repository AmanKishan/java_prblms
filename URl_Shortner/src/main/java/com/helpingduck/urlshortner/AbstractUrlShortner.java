package com.helpingduck.urlshortner;

public abstract class AbstractUrlShortner {
    private static String shortDomain = "https://hp.in/";

    abstract public String shortenUrl(String longUrl);

    abstract public String getLongUrl(String shortUrl);
}
