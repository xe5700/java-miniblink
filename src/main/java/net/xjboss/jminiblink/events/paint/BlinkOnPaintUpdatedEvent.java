package net.xjboss.jminiblink.events.paint;

import com.sun.jna.platform.win32.WinDef;
import lombok.Getter;
import lombok.ToString;
import net.xjboss.jminiblink.events.BlinkCancellableEvent;
import net.xjboss.jminiblink.webview.BlinkView;

@Getter
@ToString
public class BlinkOnPaintUpdatedEvent extends BlinkCancellableEvent {
    private WinDef.HDC hdc;
    private int x;
    private int y;
    private int cx;
    private int cy;

    public BlinkOnPaintUpdatedEvent(BlinkView view, WinDef.HDC hdc, int x, int y, int cx, int cy) {
        super(view);
        this.hdc = hdc;
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
    }
}
