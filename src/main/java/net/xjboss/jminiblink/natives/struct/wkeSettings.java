package net.xjboss.jminiblink.natives.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.xjboss.jminiblink.natives.enums.wkeProxyType;

import java.util.List;

@Getter
@Setter
public class wkeSettings extends Structure {
    private static final List<String> fields=createFieldsOrder("proxy","mask");
    private wkeProxy proxy;
    private int mask;
    protected List<String> getFieldOrder() {
        return fields;
    }

    public wkeSettings() {
    }

    public wkeSettings(Pointer peer) {
        super(peer);
    }

    public wkeSettings(wkeProxy proxy, int mask) {
        this.proxy = proxy;
        this.mask = mask;
    }

    protected wkeSettings.ByReference newByReference() { return new wkeSettings.ByReference(); }
    protected wkeSettings.ByValue newByValue() { return new wkeSettings.ByValue(); }
    protected wkeSettings newInstance() { return new wkeSettings(); }
    public static class ByReference extends wkeSettings implements Structure.ByReference {

    };
    public static class ByValue extends wkeSettings implements Structure.ByValue {

    };
}
