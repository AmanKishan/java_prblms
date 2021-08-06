package com.revolut.seourl.impl;

import com.revolut.seourl.exception.UrlManipulationException;

import java.util.Random;

public class ShortUrl extends SeoUrl {


    private static String allowStrings ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static char[] allowStringsChars =allowStrings.toCharArray();

    public ShortUrl(String baseUrl) {
        super(baseUrl);
    }

    public String get4DigitEncodedUrl(String longUrl) throws UrlManipulationException {

        Random rd =new Random();
        int randomInt = rd.nextInt(7311616) - longUrl.length();// random number less than 52^4
        StringBuilder stringBuilder= new StringBuilder();
        while(randomInt > 0){
            stringBuilder.append(allowStringsChars[randomInt%52]);
            randomInt = randomInt/52;
        }
         return getSeoUrl(stringBuilder.reverse().toString());
    }
}
