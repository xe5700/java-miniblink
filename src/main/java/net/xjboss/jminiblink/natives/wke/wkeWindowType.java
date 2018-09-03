package net.xjboss.jminiblink.natives.wke;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

public enum wkeWindowType implements NativeMapped {
    WKE_WINDOW_TYPE_POPUP,
    WKE_WINDOW_TYPE_TRANSPARENT,
    WKE_WINDOW_TYPE_CONTROL;

    wkeWindowType() {
    }

    public Object fromNative(Object nativeValue, FromNativeContext context) {
        return values()[(Integer) nativeValue];
    }

    public Object toNative() {
        return ordinal();
    }

    public Class<?> nativeType() {
        return Integer.class;
    }

}
