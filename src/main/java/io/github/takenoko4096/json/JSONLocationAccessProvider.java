package io.github.takenoko4096.json;

import io.github.takenoko4096.json.values.JSONStructure;
import org.jspecify.annotations.NullUnmarked;

/**
 * 検査例外 JSONPathUnableToAccessException を投げるための関数型インターフェース。
 * @param <S> json構造
 * @param <U> キーとなる値
 */
@FunctionalInterface
public interface JSONLocationAccessProvider<S extends JSONStructure, U> {
    U use(S structure, Object parameter) throws JSONPathUnableToAccessException;
}
