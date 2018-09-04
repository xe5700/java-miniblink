package net.xjboss.jminiblink.webview;

import net.xjboss.jminiblink.BlinkBrowser;
import net.xjboss.jminiblink.js.JsObj;
import net.xjboss.jminiblink.js.JsObjBuilder;
import net.xjboss.jminiblink.js.MBJsObj;
import net.xjboss.jminiblink.natives.NativeMiniBlink;
import net.xjboss.jminiblink.natives.pointers.jsExecState;
import net.xjboss.jminiblink.natives.struct.jsData;

import java.util.List;

public class ViewJsObj extends MBJsObj {
    private final jsExecState execState;

    public ViewJsObj(long value, NativeMiniBlink fNative, JsObjBuilder jBuidler, BlinkBrowser fBrowser, jsExecState execState) {
        super(value, fNative, jBuidler, fBrowser);
        this.execState = execState;
    }

    public jsData getData() {
        return super.getData(execState);
    }

    public int toInt() {
        return super.toInt(execState);
    }

    public double toDouble() {
        return super.toDouble(execState);
    }

    public String toString() {
        return super.toString(execState);
    }

    public JsObj get(String prop) {
        return super.get(execState, prop);
    }

    public void set(String prop, JsObj value) {
        super.set(execState, prop, value);
    }

    public List<String> getKeys() {
        return super.getKeys(execState);
    }

    public int getLength() {
        return super.getLength(execState);
    }

    public void setLength(int length) {
        super.setLength(execState, length);
    }
}
