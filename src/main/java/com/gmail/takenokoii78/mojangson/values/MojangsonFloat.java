package com.gmail.takenokoii78.mojangson.values;

import org.jspecify.annotations.NullMarked;

@NullMarked
public final class MojangsonFloat extends MojangsonNumber<Float> {
    private MojangsonFloat(float value) {
        super(value);
    }

    public static MojangsonFloat valueOf(float value) {
        return new MojangsonFloat(value);
    }
}
