package io.github.takenoko4096.mojangson.values;

import io.github.takenoko4096.mojangson.MojangsonValueType;
import io.github.takenoko4096.mojangson.MojangsonValueTypes;
import org.jspecify.annotations.NullMarked;

/**
 * mojangsonにおけるintを表現します。
 */
@NullMarked
public final class MojangsonInt extends MojangsonNumber<Integer> {
    private MojangsonInt(int value) {
        super(value);
    }

    @Override
    public MojangsonValueType<?> getType() {
        return MojangsonValueTypes.INT;
    }

    /**
     * intをMojangsonIntに変換します。
     * @param value int。
     * @return MojangsonInt。
     */
    public static MojangsonInt valueOf(int value) {
        return new MojangsonInt(value);
    }
}
