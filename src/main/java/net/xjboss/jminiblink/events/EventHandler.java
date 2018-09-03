package net.xjboss.jminiblink.events;

import static net.xjboss.jminiblink.events.EventPriority.NORMAL;

public @interface EventHandler {
    EventPriority priority() default NORMAL;
    boolean ignoreCancelled() default false;
}
