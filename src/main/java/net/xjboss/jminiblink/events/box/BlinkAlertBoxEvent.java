package net.xjboss.jminiblink.events.box;

import lombok.Getter;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public class BlinkAlertBoxEvent extends BlinkBoxEvent {
    public BlinkAlertBoxEvent(BlinkView view, String msg) {
        super(view, msg);
    }
}
