package net.xjboss.jminiblink.webview;

import net.xjboss.jminiblink.BlinkBrowser;
import net.xjboss.jminiblink.js.JsObj;
import net.xjboss.jminiblink.js.JsObjBuilder;
import net.xjboss.jminiblink.natives.NativeMiniBlink;
import net.xjboss.jminiblink.natives.enums.jsType;

public abstract class BlinkViewJSUtils extends JsObjBuilder {
    public BlinkViewJSUtils(NativeMiniBlink fNative, BlinkBrowser fBrowser) {
        super(fNative, fBrowser);
    }
    public abstract JsObj create(String str);
    public abstract JsObj create(byte[] buffer);
    public abstract JsObj create();
    public abstract int getArgCount();
    public abstract jsType getArgType(int argIdx);
    public abstract JsObj getArg(int argIdx);

}
