package net.xjboss.jminiblink.events.box;

import lombok.Getter;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkConfirmBoxEvent extends BlinkBoxEvent {
    public BlinkConfirmBoxEvent(BlinkView view, String msg) {
        super(view, msg);
    }
}
