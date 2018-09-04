package net.xjboss.jminiblink.js;

import net.xjboss.jminiblink.natives.pointers.jsExecState;

import java.util.List;

public interface JsArray extends JsObj {
    JsObj get(jsExecState es, String prop);
    void set(jsExecState es,String prop,JsObj value);
    List<String> getKeys(jsExecState es);
    int getLength(jsExecState es);
    void setLength(jsExecState es,int length);

}
