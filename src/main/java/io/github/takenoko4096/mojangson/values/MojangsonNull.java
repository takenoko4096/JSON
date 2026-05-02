package io.github.takenoko4096.mojangson.values;

import io.github.takenoko4096.mojangson.MojangsonValueType;
import io.github.takenoko4096.mojangson.MojangsonValueTypes;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * mojangsonにおけるnullを表現します。
 */
public final class MojangsonNull extends MojangsonPrimitive<Object> {
    private MojangsonNull() {
        super(null);
    }

    @Override
    public @NonNull MojangsonValueType<?> getType() {
        return MojangsonValueTypes.NULL;
    }

    @Override
    public @Nullable Object getValue() {
        return null;
    }

    @Override
    public @NonNull String toString() {
        return "null";
    }

    /**
     * シングルトンオブジェクト。
     */
    public static final MojangsonNull NULL = new MojangsonNull();
}
