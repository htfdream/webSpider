package ru.webspider.support;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class SpiderLeg
{
    SpiderLeg (String userAgent){
        USER_AGENT = userAgent;
    }
    // We'll use a fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static String USER_AGENT;

    private Document htmlDocument;

    public boolean crawl(String url) {
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            this.htmlDocument = connection.get();
            if(connection.response().statusCode() == 200) { // 200 is the HTTP OK status code
            // indicating that everything is great.
                System.out.println("\n" + Thread.currentThread().getName() + " **Visiting** Received web page at " + url);
            }
            if(!connection.response().contentType().contains("text/html")) {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            return true;
        }
        catch(IOException ioe) {
            // We were not successful in our HTTP request
            return false;
        }
    }

    public void searchForData() {

        // This method should only be used after a successful crawl.
        if(this.htmlDocument == null) {
            System.out.println("ERROR! Call crawl() before performing analysis on the document");
        }
        Elements table = this.htmlDocument.body().getElementsByClass("nogrid");
        Elements rows = table.select("tr");
        Element row;
        Elements cols;
        for (Element row1 : rows) {
            row = row1;
            cols = row.select("td");
            for (Element e : cols)
                System.out.print(e.text() + " ");
            System.out.println();
        }
    }
}