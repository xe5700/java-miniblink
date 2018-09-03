package net.xjboss.jminiblink.events;

import lombok.val;
import net.xjboss.jminiblink.BlinkListenerManager;

import java.lang.reflect.Method;
import java.util.*;

public class HandlerList<M> implements Collection<Method> {
    private final EnumMap<EventPriority,ArrayList<Method>> handlers=new EnumMap<>(EventPriority.class);
    private final Class<M> mClass;
    private final BlinkListenerManager manager;
    public HandlerList(Class<M> tClass,BlinkListenerManager tManager) {
        mClass=tClass;
        this.manager=tManager;
    }

    public ArrayList<Method> getHandlers(EventPriority level){
        return handlers.getOrDefault(level,new ArrayList<>());
    }

    public int size() {
        int s=0;
        for(val methods:handlers.values()){
            s+=methods.size();
        }
        return s;
    }

    public boolean isEmpty() {
        return handlers.isEmpty();
    }

    public boolean contains(Object o) {
        boolean tBClass=o instanceof Class;
        for(val handler:handlers.values()){
            if(!tBClass&&handler.contains(o)){
                return true;
            }else{
                val tClass=(Class<?>)o;
                for(val m:handler){
                    if(m.getDeclaringClass()==tClass){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Iterator<Method> iterator() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    public boolean add(Method method) {
        val tHandler=method.getAnnotation(EventHandler.class);
        ArrayList<Method> methods;
        methods=handlers.getOrDefault(tHandler.priority(),new ArrayList<>());
        val ret= methods.add(method);
        handlers.putIfAbsent(tHandler.priority(),methods);
        return ret;
    }

    public boolean add(Class<? extends Listener> listener){
        val lR=manager.getRegisterListener(listener);
        if(lR!=null) {
            val options=lR.getOptions().getEvents().get(mClass);
            if(options!=null) {
                return addAll(options);
            }
        }
        return false;
    }

    public boolean remove(Object object) {
        if(object instanceof Method) {
            val tMethod=(Method)object;
            val tHandler = tMethod.getAnnotation(EventHandler.class);
            ArrayList<Method> methods;
            if (tHandler != null) {
                methods = handlers.getOrDefault(tHandler.priority(), new ArrayList<>());
            }else{
                return false;
            }
            return methods.remove(tMethod);
        }else if(object instanceof Class){
            val tClass=(Class<?>)object;
            if(tClass.isAssignableFrom(Listener.class)){
                for(val handler:handlers.values()){
                    val iter=handler.iterator();
                    while (iter.hasNext()){
                        if(iter.next().getDeclaringClass()==tClass){
                            iter.remove();
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        for(Object tO:c){
            if(!contains(tO))return false;
        }
        return true;
    }

    public boolean addAll(Collection<? extends Method> c) {
        boolean tBool=true;
        for(Method tMethod:c){
            if(!add(tMethod))tBool=false;
        }
        return tBool;
    }

    public boolean removeAll(Collection<?> c) {
        boolean tBool=true;
        for(Object tO:c){
            if(!remove(tO))tBool=false;
        }
        return tBool;
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        handlers.clear();
    }
}
