package io.github.takenoko4096.mojangson.values;

import io.github.takenoko4096.mojangson.MojangsonValueType;
import io.github.takenoko4096.mojangson.MojangsonValueTypes;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * mojangsonにおけるbyteを表現します。
 */
@NullMarked
public final class MojangsonByte extends MojangsonNumber<Byte> {
    private MojangsonByte(byte value) {
        super(value);
    }

    @Override
    public MojangsonValueType<?> getType() {
        return MojangsonValueTypes.BYTE;
    }

    /**
     * booleanとして取得します。
     * @return boolean。
     */
    public boolean booleanValue() {
        return value != 0;
    }

    /**
     * byteをMojangsonByteに変換します。
     * @param value byte。
     * @return MojangsonByte。
     */
    public static MojangsonByte valueOf(byte value) {
        return new MojangsonByte(value);
    }
}
