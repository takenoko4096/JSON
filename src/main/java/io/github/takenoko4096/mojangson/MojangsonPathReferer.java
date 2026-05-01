package io.github.takenoko4096.mojangson;

import io.github.takenoko4096.mojangson.values.MojangsonStructure;

@FunctionalInterface
public interface MojangsonPathReferer<S extends MojangsonStructure, T, U> {
    U use(S structure, T parameter) throws MojangsonPathUnableToAccessException;
}

