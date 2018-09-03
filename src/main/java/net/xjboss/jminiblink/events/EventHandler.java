package net.xjboss.jminiblink.events;

import lombok.AllArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static net.xjboss.jminiblink.events.EventPriority.NORMAL;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
    EventPriority priority() default NORMAL;
    boolean ignoreCancelled() default false;
}
