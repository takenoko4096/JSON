package com.gmail.takenokoii78.mojangson.values;

import org.jspecify.annotations.NullMarked;

@NullMarked
public class MojangsonString extends MojangsonPrimitive<String> {
    private MojangsonString(String value) {
        super(value);
    }

    public static MojangsonString valueOf(String value) {
        return new MojangsonString(value);
    }

    public static MojangsonString valueOf(char value) {
        return valueOf(String.valueOf(value));
    }
}
