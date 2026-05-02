package io.github.takenoko4096.mojangson;

import io.github.takenoko4096.mojangson.values.MojangsonStructure;

/**
 * 検査例外 MojangsonPathUnableToAccessException を投げるための関数型インターフェース。
 * @param <S> mojangson構造
 * @param <U> キーとなる値
 */
@FunctionalInterface
public interface MojangsonLocationAccessProvider<S extends MojangsonStructure, U> {
    U use(S structure, Object parameter) throws MojangsonPathUnableToAccessException;
}
