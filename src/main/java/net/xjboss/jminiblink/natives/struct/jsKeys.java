package net.xjboss.jminiblink.natives.struct;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class jsKeys extends Structure {
    private static final List<String> fields=createFieldsOrder("length","keys");
    private int length;
    private StringArray keys;

    @Override
    protected List<String> getFieldOrder() {
        return fields;
    }

    public jsKeys() {
    }

    public jsKeys(int length, StringArray keys) {
        this.length = length;
        this.keys = keys;
    }

    public jsKeys(Pointer peer) {
        super(peer);
    }
    protected jsKeys.ByReference newByReference() { return new jsKeys.ByReference(); }
    protected jsKeys.ByValue newByValue() { return new jsKeys.ByValue(); }
    protected jsKeys newInstance() { return new jsKeys(); }
    public static class ByReference extends jsKeys implements Structure.ByReference {

    };
    public static class ByValue extends jsKeys implements Structure.ByValue {

    };
}
