package com.gmail.takenokoii78.mojangson.values;

import com.gmail.takenokoii78.mojangson.MojangsonValue;
import org.jspecify.annotations.NullMarked;

@NullMarked
public abstract class MojangsonPrimitive<T> extends MojangsonValue<T> {
    protected MojangsonPrimitive(T value) {
        super(value);
    }

    public T getValue() {
        return value;
    }
}
