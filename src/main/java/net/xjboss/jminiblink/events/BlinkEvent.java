package net.xjboss.jminiblink.events;

import lombok.Getter;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
public abstract class BlinkEvent {
    private final BlinkView view;
    public BlinkEvent(BlinkView view) {
        this.view = view;
    }
}
