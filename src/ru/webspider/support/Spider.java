package ru.webspider.support;

public class Spider extends Thread{
    private int start;
    private int end;
    private String url;
    private String userAgent;

    public Spider(int start, int end, String url, String userAgent) {
        this.start = start;
        this.end = end;
        this.url = url;
        this.userAgent = userAgent;
    }

    @Override
    public void run() {
        search(start, end, url);
    }

    private void search(int start, int end, String url) {
        for (int i = start; i <= end; i++) {
            if (i %200 == 0) try {
                Thread.sleep(300000); //Don't touch server 5 minutes :)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SpiderLeg leg = new SpiderLeg(this.userAgent);
            boolean success = leg.crawl(url + i);
            if (success) leg.searchForData();
            //else System.out.println(String.format(Thread.currentThread().getName() + " **Done** Visited %s web page(s)", url + i));
        }
    }
}
