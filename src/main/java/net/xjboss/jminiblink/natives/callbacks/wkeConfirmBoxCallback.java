package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface wkeConfirmBoxCallback extends Callback {
    boolean invoke(Pointer webView, Pointer param, Pointer buffer, Pointer msg);
}
