package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;

import com.sun.jna.Callback;

public interface wkeURLChangedCallback2 extends Callback {
    void invoke(Pointer webView, Pointer param, Pointer title, Pointer frameId, Pointer url);
}
