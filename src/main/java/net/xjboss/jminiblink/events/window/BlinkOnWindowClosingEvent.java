package net.xjboss.jminiblink.events.window;

import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
@ToString
public class BlinkOnWindowClosingEvent extends BlinkCancellableEvent {
    public BlinkOnWindowClosingEvent(BlinkView view) {
        super(view);
    }
}
