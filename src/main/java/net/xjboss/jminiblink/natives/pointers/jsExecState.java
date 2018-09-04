package net.xjboss.jminiblink.natives.pointers;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class jsExecState extends PointerType {
    public jsExecState() {
    }

    public jsExecState(Pointer p) {
        super(p);
    }
}
