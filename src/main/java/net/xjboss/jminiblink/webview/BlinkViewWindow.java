package net.xjboss.jminiblink.webview;

import com.sun.jna.Pointer;
import net.xjboss.jminiblink.BlinkBrowser;
import net.xjboss.jminiblink.natives.NativeMiniBlink;

public class BlinkViewWindow extends BlinkView {
    public BlinkViewWindow(NativeMiniBlink mNative, Pointer mBWebView, BlinkBrowser mBrower) {
        super(mNative, mBWebView, mBrower);
    }
    public void show(boolean show){
        fNative.wkeShowWindow(fBWebView,show);
    }
}
