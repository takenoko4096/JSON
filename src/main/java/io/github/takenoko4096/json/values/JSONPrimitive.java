package io.github.takenoko4096.json.values;

import io.github.takenoko4096.json.JSONValue;

/**
 * jsonにおけるプリミティブ値を表現します。
 * @param <T> Javaにおける値。String、Number, Mapなど。
 */
public abstract class JSONPrimitive<T> extends JSONValue<T> {
    protected JSONPrimitive(T value) {
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
