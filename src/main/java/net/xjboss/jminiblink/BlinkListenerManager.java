package net.xjboss.jminiblink;

import lombok.val;
import net.xjboss.jminiblink.events.*;
import net.xjboss.jminiblink.events.box.BlinkAlertBoxEvent;
import net.xjboss.jminiblink.events.box.BlinkBoxEvent;
import net.xjboss.jminiblink.events.box.BlinkConfirmBoxEvent;
import net.xjboss.jminiblink.events.box.BlinkPromptBoxEvent;
import net.xjboss.jminiblink.events.job.BlinkNetOnResponseEvent;
import net.xjboss.jminiblink.events.job.BlinkOnLoadUrlBeginEvent;
import net.xjboss.jminiblink.events.job.BlinkOnLoadUrlEndEvent;
import net.xjboss.jminiblink.events.net.*;
import net.xjboss.jminiblink.events.paint.BlinkOnPaintBitUpdatedEvent;
import net.xjboss.jminiblink.events.paint.BlinkOnPaintUpdatedEvent;
import net.xjboss.jminiblink.events.window.BlinkOnWindowClosingEvent;
import net.xjboss.jminiblink.events.window.BlinkOnWindowDestroyEvent;

import java.lang.reflect.Method;
import java.util.HashMap;

public class BlinkListenerManager {
    private final HashMap<Class<? extends Listener>,RegisteredListener> listeners=new HashMap<>();
    private final HashMap<Class<? extends BlinkEvent>,HandlerList<? extends BlinkEvent>> events=new HashMap<>();

    BlinkListenerManager() {
        registerDefault();
    }

    private void registerDefault(){
        registerEvent(BlinkDownloadEvent.class);
        registerEvent(BlinkOnDocumentReadyEvent.class);
        registerEvent(BlinkBoxEvent.class);
        registerEvent(BlinkOnNavigationEvent.class);
        registerEvent(BlinkPromptBoxEvent.class);
        registerEvent(BlinkAlertBoxEvent.class);
        registerEvent(BlinkConfirmBoxEvent.class);
        registerEvent(BlinkOnDocumentReadyEvent.class);
        registerEvent(BlinkOnMouseOverUrlChangedEvent.class);
        registerEvent(BlinkOnNetGetFaviconEvent.class);
        registerEvent(BlinkOnTitleChangedEvent.class);
        registerEvent(BlinkOnPaintBitUpdatedEvent.class);
        registerEvent(BlinkOnPaintUpdatedEvent.class);
        registerEvent(BlinkOnLoadUrlBeginEvent.class);
        registerEvent(BlinkOnLoadUrlEndEvent.class);
        registerEvent(BlinkNetOnResponseEvent.class);
        registerEvent(BlinkOnWindowClosingEvent.class);
        registerEvent(BlinkOnWindowDestroyEvent.class);
        registerEvent(BlinkURLChangedEvent.class);
    }
    public RegisteredListener getRegisterListener(Class<? extends Listener> tListener){
        return listeners.get(tListener);
    }
    public <E extends BlinkEvent> void registerEvent(Class<E> event){
        events.put(event,new HandlerList<>(event,this));
    }
    public <L extends Listener> void registerListener(L tObject){
        val registered=new RegisteredListener(tObject);
        val tClass=tObject.getClass();
        listeners.put(tClass,registered);
        for(val e:events.values()){
            e.add(tClass);
        }
        //listeners.put(tClass,tObject);
        //listeners.put(tObject,new HandlerList<L>(tClass,this));
    }
    public <L extends Listener> void registerListener(Class<L> tClass){
        try {
            val listener = tClass.newInstance();
            registerListener(listener);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public <L extends Listener> void unregister(Class<L> tClass){

        val registered=listeners.get(tClass);
        if(registered==null)return;
        for(val e:events.values()){
            e.remove(tClass);
        }
        listeners.remove(tClass);
    }
    public boolean callEvent(BlinkEvent event){
        try {
            HandlerList<? extends BlinkEvent> handlers = events.get(event.getClass());
            val levels = EventPriority.values();
            for (val l : levels) {
                for (Method method : handlers.getHandlers(l)) {
                    val tClass = method.getDeclaringClass();
                    if (tClass != null) {
                        val rl = listeners.get(tClass);
                        val eh=method.getAnnotation(EventHandler.class);
                        if (rl != null&&(eh.ignoreCancelled()||!(event instanceof BlinkCancellableEvent)||!((BlinkCancellableEvent) event).isCancel())) {
                            method.invoke(rl.getListener(), event);
                        }
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        if(event instanceof BlinkCancellableEvent){
            return !((BlinkCancellableEvent) event).isCancel();
        }
        return true;
    }

}
