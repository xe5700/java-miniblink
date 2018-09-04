package net.xjboss.jminiblink.events.net;

import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@ToString
@Getter
public class BlinkOnMouseOverUrlChangedEvent extends BlinkCancellableEvent {
    private String url;

    public BlinkOnMouseOverUrlChangedEvent(BlinkView view, String url) {
        super(view);
        this.url = url;
    }
}
