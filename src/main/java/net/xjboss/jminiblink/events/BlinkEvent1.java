package net.xjboss.jminiblink.events;

import lombok.Getter;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkEvent1 extends BlinkCancellableEvent {
    public BlinkEvent1(BlinkView view) {
        super(view);
    }
}
