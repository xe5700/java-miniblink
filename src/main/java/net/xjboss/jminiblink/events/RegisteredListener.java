package net.xjboss.jminiblink.events;

import lombok.Getter;

@Getter
public class RegisteredListener {
    private final Listener listener;
    private final ListenerOptions options;

    public RegisteredListener(Listener listener) {
        this.listener = listener;
        this.options=new ListenerOptions(listener);
    }

}
