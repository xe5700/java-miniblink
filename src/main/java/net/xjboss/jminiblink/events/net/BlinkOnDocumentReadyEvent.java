package net.xjboss.jminiblink.events.net;

import com.sun.jna.Pointer;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@ToString
public class BlinkOnDocumentReadyEvent extends BlinkCancellableEvent {
    private final String url;
    private final Pointer buf;
    public BlinkOnDocumentReadyEvent(BlinkView view, String url, Pointer buf) {
        super(view);
        this.url=url;
        this.buf=buf;
    }
}
