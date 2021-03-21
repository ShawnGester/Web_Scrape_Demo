package com.example.web_scrape_demo;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * A simple example, used on the jsoup website.
 */
public class Wikipedia {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.reddit.com/r/popular/").get();
        log(doc.title());

        Elements newsHeadlines = doc.select("a");
        for (Element headline : newsHeadlines) {
            Elements children = headline.children();
            if (children.size() > 0) {
                log("%s\n\t%s", headline.child(0).text(), headline.absUrl("href"));
            }
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}