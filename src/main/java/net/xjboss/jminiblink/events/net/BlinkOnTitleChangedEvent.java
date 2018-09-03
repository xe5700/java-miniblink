package net.xjboss.jminiblink.events.net;

import lombok.Getter;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;
@Getter
public class BlinkOnTitleChangedEvent extends BlinkCancellableEvent {
    private String title;
    public BlinkOnTitleChangedEvent(BlinkView view, String title) {
        super(view);
        this.title=title;
    }
}
