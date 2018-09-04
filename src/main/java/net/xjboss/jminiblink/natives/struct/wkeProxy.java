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
public class wkeProxy extends Structure {
    private static final List<String> fields=createFieldsOrder("type","hostname","port","username","password");
    private wkeProxyType type;
    private String hostname;
    private short port;
    private String username;
    private String password;
    private boolean init;
    protected List<String> getFieldOrder() {
        return fields;
    }

    public wkeProxy() {
    }

    public wkeProxy(Pointer peer) {
        super(peer);
    }

    public wkeProxy(wkeProxyType type, String hostname, short port, String username, String password, boolean init) {
        this.type = type;
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.init = init;
    }

    protected wkeProxy.ByReference newByReference() { return new wkeProxy.ByReference(); }
    protected wkeProxy.ByValue newByValue() { return new wkeProxy.ByValue(); }
    protected wkeProxy newInstance() { return new wkeProxy(); }
    public static class ByReference extends wkeProxy implements Structure.ByReference {

    };
    public static class ByValue extends wkeProxy implements Structure.ByValue {

    };

}
