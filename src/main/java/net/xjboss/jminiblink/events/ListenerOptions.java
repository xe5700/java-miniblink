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
                if(types[0].isAssignableFrom(BlinkEvent.class)){
                    ArrayList<Method> eventMethods;
                    if (events.containsKey(types[0])){
                        eventMethods=events.get(types[0]);
                    }else{
                        eventMethods=new ArrayList<Method>();
                        events.put(types[0],eventMethods);
                    }
                    eventMethods.add(method);
                }
            }
        }
    }
}
