package io.github.takenoko4096.json;

import io.github.takenoko4096.json.values.JSONStructure;
import org.jspecify.annotations.NullUnmarked;

@NullUnmarked
@FunctionalInterface
public interface JSONPathReferer<S extends JSONStructure, T, U> {
    U use(S structure, T parameter) throws JSONPathUnableToAccessException;
}
