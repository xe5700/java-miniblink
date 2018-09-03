package net.xjboss.jminiblink.objects;

import lombok.Getter;
import lombok.Setter;

public class AObj<T> {
    @Setter
    @Getter
    private T obj;
}
