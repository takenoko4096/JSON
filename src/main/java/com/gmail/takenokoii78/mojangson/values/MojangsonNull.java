package com.gmail.takenokoii78.mojangson.values;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public final class MojangsonNull extends MojangsonPrimitive<Object> {
    private MojangsonNull() {
        super(null);
    }

    @Override
    public @Nullable Object getValue() {
        return null;
    }

    @Override
    public String toString() {
        return "null";
    }

    public static final MojangsonNull NULL = new MojangsonNull();
}
