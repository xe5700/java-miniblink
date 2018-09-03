package net.xjboss.jminiblink.natives;

import com.sun.jna.Library;

public interface MiniBlinkInfo extends Library {
    long getVersion();

}
