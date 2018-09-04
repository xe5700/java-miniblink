package net.xjboss.jminiblink.js;

import lombok.Getter;
import net.xjboss.jminiblink.natives.enums.jsType;
import net.xjboss.jminiblink.natives.pointers.jsExecState;
import net.xjboss.jminiblink.natives.struct.jsData;

public interface JsObj {
    long getValue();
    jsType getType();
    boolean isNumber();
    boolean isString();
    boolean isObject();
    boolean isFunction();
    boolean isUndefined();
    boolean isBoolean();
    boolean isArray();
    boolean isNull();
    boolean toBoolean();
    int toInt(jsExecState es);
    double toDouble(jsExecState es);
    String toString(jsExecState es);
    jsData getData(jsExecState es);


}
