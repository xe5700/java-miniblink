package net.xjboss.jminiblink.events.box;

import lombok.Getter;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkBoxEvent extends BlinkCancellableEvent {
    private String msg;

    public BlinkBoxEvent(BlinkView view, String msg) {
        super(view);
        this.msg = msg;
    }
}
