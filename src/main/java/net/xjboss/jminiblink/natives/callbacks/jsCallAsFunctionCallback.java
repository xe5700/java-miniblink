package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Callback;
import net.xjboss.jminiblink.natives.pointers.jsExecState;

public interface jsCallAsFunctionCallback extends Callback {
     long apply(jsExecState es, long object, long args, int argCount);
}
