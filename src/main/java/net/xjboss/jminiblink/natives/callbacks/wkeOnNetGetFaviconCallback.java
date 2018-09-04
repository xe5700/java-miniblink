package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;

import com.sun.jna.Callback;
import net.xjboss.jminiblink.natives.struct.wkeMemBuf;

public interface wkeOnNetGetFaviconCallback extends Callback {
    void invoke(Pointer webView, Pointer param, String url,wkeMemBuf buf);
}
