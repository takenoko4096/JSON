package io.github.takenoko4096.mojangson.values;

import io.github.takenoko4096.mojangson.MojangsonValueType;
import io.github.takenoko4096.mojangson.MojangsonValueTypes;
import org.jspecify.annotations.NullMarked;

/**
 * mojangsonにおけるfloatを表現します。
 */
@NullMarked
public final class MojangsonFloat extends MojangsonNumber<Float> {
    private MojangsonFloat(float value) {
        super(value);
    }

    @Override
    public MojangsonValueType<?> getType() {
        return MojangsonValueTypes.FLOAT;
    }

    /**
     * floatをMojangsonFloatに変換します。
     * @param value float。
     * @return MojangsonFloat。
     */
    public static MojangsonFloat valueOf(float value) {
        return new MojangsonFloat(value);
    }
}
