package net.xjboss.jminiblink.events;

public interface Cancellable {
    boolean isCancel();
    void setCancel(boolean cancel);
}
