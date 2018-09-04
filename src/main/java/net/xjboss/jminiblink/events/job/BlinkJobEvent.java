package net.xjboss.jminiblink.events.job;

import com.sun.jna.Pointer;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;
@Getter
@ToString
public abstract class BlinkJobEvent extends BlinkCancellableEvent {
    private String url;
    private Pointer jobPtr;

    public BlinkJobEvent(BlinkView view, String url, Pointer jobPtr) {
        super(view);
        this.url = url;
        this.jobPtr = jobPtr;
    }
}
