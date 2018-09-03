package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;

import com.sun.jna.Callback;

public interface wkeConsoleCallback extends Callback {
    void invoke(Pointer webView, Pointer param, Pointer level, Pointer message,Pointer sourceName,int sourceLine,Pointer stackTrace);
}
