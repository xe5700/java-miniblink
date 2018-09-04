package net.xjboss.jminiblink.events.net;

import com.sun.jna.Pointer;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@ToString
public class BlinkDownloadEvent extends BlinkCancellableEvent {
    @Getter
    private String url;
    public BlinkDownloadEvent(BlinkView view, String url) {
        super(view);
        this.url=url;
    }
}
