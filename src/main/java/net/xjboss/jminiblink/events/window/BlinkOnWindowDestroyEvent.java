package net.xjboss.jminiblink.events.window;

import lombok.Getter;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkOnWindowDestroyEvent extends BlinkCancellableEvent {
    public BlinkOnWindowDestroyEvent(BlinkView view) {
        super(view);
    }
}
