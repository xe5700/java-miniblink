package net.xjboss.jminiblink.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import net.xjboss.jminiblink.BlinkBrowser;
import net.xjboss.jminiblink.natives.NativeMiniBlink;
import net.xjboss.jminiblink.natives.enums.jsType;
import net.xjboss.jminiblink.natives.pointers.jsExecState;
import net.xjboss.jminiblink.natives.struct.jsData;

import java.util.Arrays;
import java.util.List;

import static net.xjboss.jminiblink.natives.enums.jsType.*;
@EqualsAndHashCode(of={"value"})
public class MBJsObj implements JsObj,JsArray {
    @Getter
    private final long value;
    private final NativeMiniBlink fNative;
    private final JsObjBuilder jBuidler;
    private final BlinkBrowser fBrowser;

    public MBJsObj(long value, NativeMiniBlink fNative, JsObjBuilder jBuidler, BlinkBrowser fBrowser) {
        this.value = value;
        this.fNative = fNative;
        this.jBuidler = jBuidler;
        this.fBrowser = fBrowser;
    }

    @Override
    public jsType getType() {
        val aobj=new AObj<jsType>();
        fBrowser.autoRunTask(()->
            aobj.setObj(values()[fNative.jsTypeOf(value)])
        );
        return aobj.getObj();
    }

    @Override
    public boolean isNumber() {
        return getType()==JSTYPE_NUMBER;
    }

    @Override
    public boolean isString() {
        return getType()==JSTYPE_STRING;
    }

    @Override
    public boolean isObject() {
        return getType()==JSTYPE_OBJECT;
    }

    @Override
    public boolean isFunction() {
        return getType()==JSTYPE_FUNCTION;
    }

    @Override
    public boolean isUndefined() {
        return getType()==JSTYPE_UNDEFINED;
    }

    @Override
    public boolean isNull() {
        return fNative.jsIsNull(value);
    }

    @Override
    public jsData getData(jsExecState es) {
        val aobj=new AObj<jsData>();
        fBrowser.autoRunTask(()->
                aobj.setObj(fNative.jsGetData(es,value))
        );
        return aobj.getObj();
    }

    @Override
    public boolean isBoolean() {
        return getType()==JSTYPE_BOOLEAN;
    }

    @Override
    public boolean isArray() {
        return getType()==JSTYPE_ARRAY;
    }

    @Override
    public boolean toBoolean() {
        val aobj=new AObj<Boolean>();
        fBrowser.autoRunTask(()->
                aobj.setObj(fNative.jsIsTrue(value))
        );
        return aobj.getObj();
    }

    @Override
    public int toInt(jsExecState es) {
        val aobj=new AObj<Integer>();
        fBrowser.autoRunTask(()->
                aobj.setObj(fNative.jsToInt(es,value))
        );
        return aobj.getObj();
    }

    @Override
    public double toDouble(jsExecState es) {
        val aobj=new AObj<Double>();
        fBrowser.autoRunTask(()->
                aobj.setObj( fNative.jsToDouble(es,value))
        );
        return aobj.getObj();
    }

    @Override
    public String toString(jsExecState es) {
        val aobj=new AObj<String>();
        fBrowser.autoRunTask(()->
                aobj.setObj(fNative.jsToString(es,value))
        );
        return aobj.getObj();
    }

    @Override
    public JsObj get(jsExecState es, String prop) {
        val aobj=new AObj<Long>();
        fBrowser.autoRunTask(()->{
                    val v=fNative.jsGet(es,value,prop);
                    aobj.setObj(v);
                }
        );
        return jBuidler.newObj(aobj.getObj());
    }

    @Override
    public void set(jsExecState es, String prop, JsObj value) {
        fBrowser.autoRunTask(()->
                fNative.jsSet(es,this.value,prop,value.getValue())
        );
    }

    @Override
    public List<String> getKeys(jsExecState es) {
        val aobj=new AObj<List<String>>();
        fBrowser.autoRunTask(()-> {
            val keys = fNative.jsGetKeys(es, value);
            aobj.setObj(Arrays.asList(keys.getKeys().getStringArray(0,keys.size(),"UTF-8")));
        });
        return aobj.getObj();
    }


    @Override
    public int getLength(jsExecState es) {
        val aobj=new AObj<Integer>();
        fBrowser.autoRunTask(()->
                aobj.setObj(fNative.jsGetLength(es,value))
        );
        return aobj.getObj();
}

    @Override
    public void setLength(jsExecState es, int length) {
        val aobj=new AObj<Boolean>();
        fBrowser.autoRunTask(()->
                aobj.setObj(fNative.jsIsTrue(value))
        );
        fNative.jsSetLength(es,value,length);
    }
}
