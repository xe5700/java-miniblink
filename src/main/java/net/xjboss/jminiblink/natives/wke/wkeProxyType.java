package net.xjboss.jminiblink.natives.wke;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

public enum  wkeProxyType implements NativeMapped {
    WKE_PROXY_NONE,
    WKE_PROXY_HTTP,
    WKE_PROXY_SOCKS4,
    WKE_PROXY_SOCKS4A,
    WKE_PROXY_SOCKS5,
    WKE_PROXY_SOCKS5HOSTNAME;

    wkeProxyType() {
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
