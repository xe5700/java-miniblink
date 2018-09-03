package net.xjboss.jminiblink.natives;

import com.sun.jna.Library;

public interface NativeWinUtil extends Library {
    void handleWindow();
    boolean canLoop();
}
