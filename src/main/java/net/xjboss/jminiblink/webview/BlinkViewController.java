package net.xjboss.jminiblink.webview;

public interface BlinkViewController {
    boolean back();
    boolean forward();
    void stop();
    boolean reload();
    void loadURL(String url);
    void loadHTML(String html);
    void loadHTMLWithBaseUrl(String html,String baseUrl);
    void loadFile(String filename);
}
