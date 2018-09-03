package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;

public interface wkeNavigationCallback {
    void invoke(Pointer webView, Pointer param, int navigationType, Pointer url);
}
