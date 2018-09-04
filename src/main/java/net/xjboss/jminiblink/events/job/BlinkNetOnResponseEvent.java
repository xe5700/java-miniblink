package net.xjboss.jminiblink.events.job;

import com.sun.jna.Pointer;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.job.BlinkJobEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkNetOnResponseEvent extends BlinkJobEvent {
    public BlinkNetOnResponseEvent(BlinkView view, String url, Pointer jobPtr) {
        super(view, url, jobPtr);
    }
}
