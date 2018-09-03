package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface wkeAlertBoxCallback extends Callback {
    void invoke(Pointer webView, Pointer param, Pointer buffer, Pointer msg);
}
