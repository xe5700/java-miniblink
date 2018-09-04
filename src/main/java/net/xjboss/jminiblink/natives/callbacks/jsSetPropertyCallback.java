package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import net.xjboss.jminiblink.natives.pointers.jsExecState;

public interface jsSetPropertyCallback extends Callback {
		byte apply(jsExecState es, long object, Pointer propertyName, long value);
};