package com.revolut.seourl;

import com.revolut.seourl.exception.UrlManipulationException;
import com.revolut.seourl.impl.SeoUrl;
import com.revolut.seourl.impl.ShortUrl;

public class Solution {

    public static void main(String[] args)  {

        UrlManipulation urlManipulation = new SeoUrl("http://www.short.com/");
        ShortUrl shortUrl = new ShortUrl("http://www.short.com/");
        try{
            //System.out.println(urlManipulation.getManipulatedUrl("MY-NEW-WS---------YYYYYYYYYYYYY-YYYYYYYY"));
            //System.out.println(urlManipulation.getSeoUrl(null));
            System.out.println(shortUrl.get4DigitEncodedUrl("http://aman.com/rererererer"));
        }catch (UrlManipulationException e){
            System.err.println(e.getMessage() + " Exception trace : " + e);
        }catch(Exception ex){
            System.err.println("Some error occurred" + ex.getMessage() + "Exception trace : " + ex);
        }
    }
}
