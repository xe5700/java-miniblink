package net.xjboss.jminiblink.natives.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

public enum jsType implements NativeMapped {
    JSTYPE_NUMBER,
    JSTYPE_STRING,
    JSTYPE_BOOLEAN,
    JSTYPE_OBJECT,
    JSTYPE_FUNCTION,
    JSTYPE_UNDEFINED,
    JSTYPE_ARRAY,
    JSTYPE_NULL;

    jsType() {
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
