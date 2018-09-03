package net.xjboss.jminiblink.natives.wke;

import com.sun.jna.Structure;
import lombok.Data;

import java.util.List;

@Data
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

}
