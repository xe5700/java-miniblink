package net.xjboss.jminiblink.natives.wke;

import com.sun.jna.Structure;
import lombok.Data;

import java.util.List;

@Data
public class wkeSettings extends Structure {
    private static final List<String> fields=createFieldsOrder("proxy","mask");
    private wkeProxy proxy;
    private int mask;
    protected List<String> getFieldOrder() {
        return fields;
    }

}
