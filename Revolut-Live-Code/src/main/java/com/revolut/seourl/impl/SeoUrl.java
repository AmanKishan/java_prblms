package com.revolut.seourl.impl;

import com.revolut.seourl.UrlManipulation;
import com.revolut.seourl.exception.UrlManipulationException;
import lombok.NonNull;

public class SeoUrl extends UrlManipulation {

    public SeoUrl(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String getSeoUrl(@NonNull  String seoKeyword) throws UrlManipulationException {

        if(seoKeyword.length() <= 20){
            return baseUrl+seoKeyword;
        }
        throw new UrlManipulationException("Seo Keyword Length can't be greater than 20");
    }
}
