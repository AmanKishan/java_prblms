package com.revolut.seourl;

import com.revolut.seourl.exception.UrlManipulationException;

public abstract class UrlManipulation {


    public String baseUrl;

    public UrlManipulation(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public abstract String getSeoUrl(String seoKeyword) throws UrlManipulationException;

}
