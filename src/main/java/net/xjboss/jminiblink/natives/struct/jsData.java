package net.xjboss.jminiblink.natives.struct;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class jsData extends Structure {
    private static final List<String> fields=createFieldsOrder("typeName","propertyGet","propertySet","finalize","callAsFunction");
    private byte[] typeName=new byte[100];
    private StringArray keys;

    public jsData() {
    }

    public jsData(byte[] typeName, StringArray keys) {
        this.typeName = typeName;
        this.keys = keys;
    }

    public jsData(Pointer p) {
        super(p);
    }

    protected jsData.ByReference newByReference() { return new jsData.ByReference(); }
    protected jsData.ByValue newByValue() { return new jsData.ByValue(); }
    protected jsData newInstance() { return new jsData(); }
    public static class ByReference extends jsData implements Structure.ByReference {

    };
    public static class ByValue extends jsData implements Structure.ByValue {

    };
    @Override
    protected List<String> getFieldOrder() {
        return fields;
    }
}
