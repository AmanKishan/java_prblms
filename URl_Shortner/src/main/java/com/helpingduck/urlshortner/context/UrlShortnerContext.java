package com.helpingduck.urlshortner.context;

import com.helpingduck.urlshortner.AbstractUrlShortner;
import com.helpingduck.urlshortner.data.UrlShortnerData;
import com.helpingduck.urlshortner.strategy.impl.Base62UrlShortner;

public class UrlShortnerContext {

    private AbstractUrlShortner abstractUrlShortner;

    public UrlShortnerContext(AbstractUrlShortner abstractUrlShortner) {
        this.abstractUrlShortner = abstractUrlShortner;
    }

    public String shortenUrl(String longUrl){
        return this.abstractUrlShortner.shortenUrl(longUrl);
    }

    public String getLongUrl(String shortUrl){
        return this.abstractUrlShortner.getLongUrl(shortUrl);
    }

    public static void main(String[] args) {

        AbstractUrlShortner abstractUrlShortner = new Base62UrlShortner();

        UrlShortnerContext urlShortnerContext = new UrlShortnerContext(abstractUrlShortner);

        String shortUrl = urlShortnerContext.shortenUrl("https://aman.com/hello-my-first-url-shortner-program");

        System.out.println(UrlShortnerData.idUrlMap.values());

        System.out.println(shortUrl);

        System.out.println(urlShortnerContext.getLongUrl(shortUrl));

    }
}