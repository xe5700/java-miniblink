package net.xjboss.jminiblink.events.net;

import lombok.Getter;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.natives.enums.wkeNavigationType;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkOnNavigationEvent extends BlinkCancellableEvent {
    private wkeNavigationType type;
    private String url;

    public BlinkOnNavigationEvent(BlinkView view, wkeNavigationType type, String url) {
        super(view);
        this.type = type;
        this.url = url;
    }
}
