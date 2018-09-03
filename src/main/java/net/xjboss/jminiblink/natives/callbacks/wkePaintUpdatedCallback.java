package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;

import com.sun.jna.Callback;

public interface wkePaintUpdatedCallback extends Callback {
    void invoke(Pointer webView, Pointer param, WinDef.HDC hdc, int x, int y, int cx,int cy);
}
