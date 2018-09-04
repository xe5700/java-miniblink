package net.xjboss.jminiblink.natives.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

public enum wkeNavigationType implements NativeMapped {
    WKE_NAVIGATION_TYPE_LINKCLICK,
    WKE_NAVIGATION_TYPE_FORMSUBMITTE,
    WKE_NAVIGATION_TYPE_BACKFORWARD,
    WKE_NAVIGATION_TYPE_RELOAD,
    WKE_NAVIGATION_TYPE_FORMRESUBMITT,
    WKE_NAVIGATION_TYPE_OTHER;

    wkeNavigationType() {
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
