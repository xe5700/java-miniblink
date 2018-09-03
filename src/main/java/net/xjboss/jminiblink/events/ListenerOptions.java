package net.xjboss.jminiblink.events;

import lombok.Getter;
import lombok.val;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListenerOptions {
    @Getter
    private Map<Class,ArrayList<Method>> events=new HashMap<Class, ArrayList<Method>>();
    public ListenerOptions(Listener listener){
        val methods=listener.getClass().getMethods();
        for(val method:methods){
            val types=method.getParameterTypes();
            if(types.length==1){
                if(BlinkEvent.class.isAssignableFrom(types[0])&&method.getAnnotation(EventHandler.class)!=null){
                    ArrayList<Method> eventMethods=events.getOrDefault(types[0],new ArrayList<>());
                    eventMethods.add(method);
                    events.putIfAbsent(types[0],eventMethods);
                }
            }
        }
    }
}
