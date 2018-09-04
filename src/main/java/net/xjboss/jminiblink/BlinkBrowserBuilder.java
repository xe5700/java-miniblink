package net.xjboss.jminiblink;

public class BlinkBrowserBuilder {
    public static BlinkBrowser create(){
        return create(null);
    }
    public synchronized static BlinkBrowser create(BlinkSetting setting){
        if(BlinkBrowser.getInstance()!=null)return BlinkBrowser.getInstance();
        return new BlinkBrowser(setting);
    }
}
