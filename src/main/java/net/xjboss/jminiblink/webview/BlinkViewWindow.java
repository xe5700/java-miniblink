package net.xjboss.jminiblink.webview;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import net.xjboss.jminiblink.BlinkBrowser;
import net.xjboss.jminiblink.natives.NativeMiniBlink;

public class BlinkViewWindow extends BlinkView {
    public BlinkViewWindow(NativeMiniBlink mNative, Pointer mBWebView, BlinkBrowser mBrower) {
        super(mNative, mBWebView, mBrower);
    }

    public void setTitle(String title){
        fBrowser.autoRunTask(()->{
            fNative.wkeSetWindowTitle(fBWebView,title);
        });
    }

    public void show(boolean show){
        fBrowser.autoRunTask(()->{
            fNative.wkeShowWindow(fBWebView,show);
        });
    }
}
