package com.gmail.takenokoii78.mojangson.values;

import org.jspecify.annotations.NullMarked;

@NullMarked
public final class MojangsonInt extends MojangsonNumber<Integer> {
    private MojangsonInt(int value) {
        super(value);
    }

    public static MojangsonInt valueOf(int value) {
        return new MojangsonInt(value);
    }
}
