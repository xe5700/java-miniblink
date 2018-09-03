package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface wkeCreateViewCallback extends Callback {
    Pointer invoke(Pointer webView, Pointer param, Pointer buffer, Pointer navigationType, Pointer url,Pointer windowFeatures);
}
