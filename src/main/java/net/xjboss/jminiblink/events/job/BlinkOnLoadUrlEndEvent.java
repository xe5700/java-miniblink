package net.xjboss.jminiblink.events.job;

import com.sun.jna.Pointer;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
@ToString(callSuper = true)
public class BlinkOnLoadUrlEndEvent extends BlinkJobEvent {
    private byte[] buffer;

    public BlinkOnLoadUrlEndEvent(BlinkView view, String url, Pointer jobPtr, byte[] buffer) {
        super(view, url, jobPtr);
        this.buffer = buffer;
    }

}
