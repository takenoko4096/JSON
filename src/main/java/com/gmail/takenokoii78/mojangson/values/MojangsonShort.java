package com.gmail.takenokoii78.mojangson.values;

import org.jspecify.annotations.NullMarked;

@NullMarked
public final class MojangsonShort extends MojangsonNumber<Short> {
    private MojangsonShort(short value) {
        super(value);
    }

    public static MojangsonShort valueOf(short value) {
        return new MojangsonShort(value);
    }
}
