package net.xjboss.jminiblink.events.net;

import com.sun.jna.Pointer;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
@ToString
public class BlinkURLChangedEvent extends BlinkCancellableEvent {
    private String url;
    private Pointer frameId;

    public BlinkURLChangedEvent(BlinkView view, String url, Pointer frameId) {
        super(view);
        this.url = url;
        this.frameId = frameId;
    }
}
