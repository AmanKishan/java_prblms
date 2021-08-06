package com.helpingduck.urlshortner.strategy.impl;

import com.helpingduck.urlshortner.AbstractUrlShortner;
import com.helpingduck.urlshortner.data.UrlShortnerData;

import java.util.Random;

public class Base62UrlShortner extends AbstractUrlShortner {

    private static final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] allowedCharacters = allowedString.toCharArray();
    private int base = allowedCharacters.length;
    private int shortUrlLength = 8;

    public String encode(long input){

        StringBuilder encodedBuilder = new StringBuilder();
        while(input > 0){
            encodedBuilder.append(allowedCharacters[(int) (input % base)]);
            input = input/base;
        }
        return encodedBuilder.reverse().toString();
    }

    public long decode(String input) {
        char[] characters = input.toCharArray();
        int length = characters.length;

        long decoded = 0;

        //counter is used to avoid reversing input string
        int counter = 1;
        for (int i = 0; i < length; i++) {
            decoded += allowedString.indexOf(characters[i]) * Math.pow(base, length - counter);
            counter++;
        }
        return decoded;
    }

    public String shortenUrl(String longUrl) {
        Random random = new Random();
        long id = Math.abs(random.nextInt());
        UrlShortnerData.idUrlMap.put(id,longUrl);
        return encode(id);
    }

    @Override
    public String getLongUrl(String shortUrl) {
        Long id = decode(shortUrl);
        return UrlShortnerData.idUrlMap.get(id);
    }
}
