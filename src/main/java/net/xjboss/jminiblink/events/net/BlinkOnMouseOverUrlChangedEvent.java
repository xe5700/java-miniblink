package net.xjboss.jminiblink.events.net;

import lombok.Getter;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkOnMouseOverUrlChangedEvent extends BlinkCancellableEvent {
    private String url;

    public BlinkOnMouseOverUrlChangedEvent(BlinkView view, String url) {
        super(view);
        this.url = url;
    }
}
