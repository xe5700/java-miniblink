package net.xjboss.jminiblink.natives.wke;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

public enum wkeRequestType implements NativeMapped {

    kWkeRequestTypeInvalidation,
    kWkeRequestTypeGet,
    kWkeRequestTypePost,
    kWkeRequestTypePut;


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
