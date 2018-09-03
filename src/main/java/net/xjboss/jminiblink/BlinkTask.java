package net.xjboss.jminiblink;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlinkTask {
    private final Thread current;
    private final Object obj=new Object();
    @Getter
    private final Runnable runnable;
    void start(){
        synchronized (obj){
            runnable.run();
            obj.notifyAll();
        }
    }
    public void join(){
        synchronized (obj){
            try {
                obj.wait();
            }catch (Exception e){

            }
        }
    }
}
