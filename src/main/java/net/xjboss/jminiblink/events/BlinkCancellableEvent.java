package net.xjboss.jminiblink.events;

import lombok.Getter;
import lombok.Setter;
import net.xjboss.jminiblink.webview.BlinkView;


@Getter
@Setter
public abstract class BlinkCancellableEvent extends BlinkEvent implements Cancellable {
    private boolean cancel;
    public BlinkCancellableEvent(BlinkView view) {
        super(view);
    }
}
