package net.xjboss.jminiblink.events;

import lombok.Getter;
import lombok.Setter;
import net.xjboss.jminiblink.webview.BlinkView;


public abstract class BlinkCancellableEvent extends BlinkEvent implements Cancellable {
    @Getter
    @Setter
    private boolean cancel;
    public BlinkCancellableEvent(BlinkView view) {
        super(view);
    }
}
