package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;

public interface wkeCreateViewCallback {
    void invoke(Pointer webView, Pointer param, Pointer buffer, Pointer navigationType, Pointer url,Pointer windowFeatures);
}
