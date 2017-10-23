package ru.webspider;
import ru.webspider.support.Spider;

public class Main {

    public static void main(String[] args) {
        String url = "http://";
        String userAgent1 = "Mozilla/5.1 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.1.782.111 Safari/535.1";
        String userAgent2 = "Mozilla/5.2 (Windows NT 6.2; WOW32) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/13.2.782.112 Safari/535.2";
        String userAgent3 = "Mozilla/5.3 (Windows NT 6.3; WOW64) AppleWebKit/535.3 (KHTML, like Gecko) Chrome/13.3.782.113 Safari/535.3";
        String userAgent4 = "Mozilla/5.4 (Windows NT 6.4; WOW32) AppleWebKit/535.4 (KHTML, like Gecko) Chrome/13.4.782.114 Safari/535.4";
        String userAgent5 = "Mozilla/5.5 (Windows NT 6.5; WOW32) AppleWebKit/535.5 (KHTML, like Gecko) Chrome/13.4.782.115 Safari/535.5";

        Spider spider1 = new Spider(0, 10000, url, userAgent1);
        spider1.start();
        Spider spider2 = new Spider(10001, 20000, url, userAgent2);
        spider2.start();
        Spider spider3 = new Spider(20001, 30000, url, userAgent3);
        spider3.start();
        Spider spider4 = new Spider(30001, 40000, url, userAgent4);
        spider4.start();
        Spider spider5 = new Spider(40001, 50000, url, userAgent5);
        spider5.start();
    }
}
