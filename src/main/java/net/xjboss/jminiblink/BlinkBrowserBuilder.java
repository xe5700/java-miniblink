package net.xjboss.jminiblink;

public class BlinkBrowserBuilder {
    public static BlinkBrowser create(){
        return new BlinkBrowser();
    }
    public static BlinkBrowser create(BlinkSetting setting){
        return new BlinkBrowser(setting);
    }
}
