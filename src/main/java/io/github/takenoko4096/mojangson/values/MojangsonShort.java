package io.github.takenoko4096.mojangson.values;

import io.github.takenoko4096.mojangson.MojangsonValueType;
import io.github.takenoko4096.mojangson.MojangsonValueTypes;
import org.jspecify.annotations.NullMarked;

/**
 * mojangsonにおけるshortを表現します。
 */
@NullMarked
public final class MojangsonShort extends MojangsonNumber<Short> {
    private MojangsonShort(short value) {
        super(value);
    }

    @Override
    public MojangsonValueType<?> getType() {
        return MojangsonValueTypes.SHORT;
    }

    /**
     * shortをMojangsonShortに変換します。
     * @param value short。
     * @return MojangsonShort。
     */
    public static MojangsonShort valueOf(short value) {
        return new MojangsonShort(value);
    }
}
