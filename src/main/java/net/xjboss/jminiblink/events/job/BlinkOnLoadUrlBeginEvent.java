package net.xjboss.jminiblink.events.job;

import com.sun.jna.Pointer;
import lombok.Getter;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkOnLoadUrlBeginEvent extends BlinkJobEvent {
    public BlinkOnLoadUrlBeginEvent(BlinkView view, String url, Pointer jobPtr) {
        super(view, url, jobPtr);
    }
}
