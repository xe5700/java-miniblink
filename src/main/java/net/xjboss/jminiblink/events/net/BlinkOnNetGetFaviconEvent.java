package net.xjboss.jminiblink.events.net;

import com.sun.jna.Pointer;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;
@Getter
@ToString
public class BlinkOnNetGetFaviconEvent extends BlinkCancellableEvent {
    private String url;
    private byte[] buf;

    public BlinkOnNetGetFaviconEvent(BlinkView view, String url, byte[] buf) {
        super(view);
        this.url = url;
        this.buf = buf;
    }
}
