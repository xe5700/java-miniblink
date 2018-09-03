package net.xjboss.jminiblink.events;

import net.xjboss.jminiblink.webview.BlinkView;


public abstract class BlinkEvent {
    private final BlinkView view;
    public BlinkEvent(BlinkView view) {
        this.view = view;
    }
}
