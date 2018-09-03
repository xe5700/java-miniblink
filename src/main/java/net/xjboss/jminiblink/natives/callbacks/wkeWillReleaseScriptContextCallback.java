package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;

import com.sun.jna.Callback;

public interface wkeWillReleaseScriptContextCallback extends Callback {
    void invoke(Pointer webView, Pointer param, Pointer frameId, Pointer context,int worldId);
}
