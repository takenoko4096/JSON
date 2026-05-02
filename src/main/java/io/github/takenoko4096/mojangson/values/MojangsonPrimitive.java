package io.github.takenoko4096.mojangson.values;

import io.github.takenoko4096.mojangson.MojangsonValue;
import org.jspecify.annotations.NullMarked;

/**
 * mojangsonにおけるプリミティブ値を表現します。
 * @param <T> Javaにおける値。String、Number, Mapなど。
 */
public abstract class MojangsonPrimitive<T> extends MojangsonValue<T> {
    protected MojangsonPrimitive(T value) {
        super(value);
    }

    /**
     * ラップされていた値を取得します。
     * @return Javaにおける値。
     */
    public T getValue() {
        return value;
    }
}
