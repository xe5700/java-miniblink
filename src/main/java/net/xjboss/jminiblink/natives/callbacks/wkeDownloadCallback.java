package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;

import javax.security.auth.callback.Callback;

public interface wkeDownloadCallback extends Callback {
    void invoke(Pointer webView, Pointer param, String url);
}
