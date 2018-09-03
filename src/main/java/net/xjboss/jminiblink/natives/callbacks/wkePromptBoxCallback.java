package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;

public interface wkePromptBoxCallback {
    void invoke(Pointer webView, Pointer param, Pointer buffer, Pointer msg,Pointer defaultResult,Pointer result);
}
