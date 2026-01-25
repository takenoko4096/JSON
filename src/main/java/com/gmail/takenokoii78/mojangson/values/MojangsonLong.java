package com.gmail.takenokoii78.mojangson.values;

import org.jspecify.annotations.NullMarked;

@NullMarked
public final class MojangsonLong extends MojangsonNumber<Long> {
    private MojangsonLong(long value) {
        super(value);
    }

    public static MojangsonLong valueOf(long value) {
        return new MojangsonLong(value);
    }
}
