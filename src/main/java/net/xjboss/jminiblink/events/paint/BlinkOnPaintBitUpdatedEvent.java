package net.xjboss.jminiblink.events.paint;

import com.sun.jna.Pointer;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
@ToString

public class BlinkOnPaintBitUpdatedEvent extends BlinkCancellableEvent {
    private byte[] buffer;
    private Pointer r;
    private int width;
    private int height;

    public BlinkOnPaintBitUpdatedEvent(BlinkView view, byte[] buffer, Pointer r, int width, int height) {
        super(view);
        this.buffer = buffer;
        this.r = r;
        this.width = width;
        this.height = height;
    }
}
