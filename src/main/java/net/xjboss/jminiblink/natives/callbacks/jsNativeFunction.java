package net.xjboss.jminiblink.natives.callbacks;

import com.sun.jna.Callback;
import net.xjboss.jminiblink.natives.pointers.jsExecState;

public interface jsNativeFunction extends Callback {
    long invoke(jsExecState es);
}
