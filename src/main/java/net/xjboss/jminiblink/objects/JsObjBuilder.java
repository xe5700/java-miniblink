package net.xjboss.jminiblink.objects;

import com.sun.jna.Memory;
import lombok.val;
import net.xjboss.jminiblink.BlinkBrowser;
import net.xjboss.jminiblink.natives.NativeMiniBlink;
import net.xjboss.jminiblink.natives.pointers.jsExecState;

public class JsObjBuilder {
    private final NativeMiniBlink fNative;
    private final BlinkBrowser fBrowser;

    public JsObjBuilder(NativeMiniBlink fNative, BlinkBrowser fBrowser) {
        this.fNative = fNative;
        this.fBrowser = fBrowser;
    }

    public JsObj create(int n) {
        val obj=new AObj<Long>();
        fBrowser.autoRunTask(()->{
            obj.setObj(fNative.jsInt(n));
        });
        return newObj(obj.getObj());
    }

    public JsObj create(jsExecState es, String str) {
        val obj=new AObj<Long>();
        fBrowser.autoRunTask(()->{
            obj.setObj(fNative.jsString(es,str));
        });
        return newObj(obj.getObj());
    }

    public JsObj create(jsExecState es, byte[] buffer) {
        val obj=new AObj<Long>();
        fBrowser.autoRunTask(()->{
            val mem=Memory.createConstant(buffer.length);
            obj.setObj(fNative.jsArrayBuffer(es,mem,buffer.length));
        });
        return newObj(obj.getObj());
    }

    public JsObj create(jsExecState es) {
        val obj=new AObj<Long>();
        fBrowser.autoRunTask(()->{
            obj.setObj(fNative.jsEmptyObject(es));
        });
        return newObj(obj.getObj());
    }

    JsObj newObj(long v){
        return new MBJsObj(v,fNative,this,fBrowser);
    }

}
