package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface wkePromptBoxCallback extends Callback {
    boolean invoke(Pointer webView, Pointer param, Pointer buffer, Pointer msg,Pointer defaultResult,Pointer result);
}
