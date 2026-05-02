package io.github.takenoko4096.mojangson;

import org.jspecify.annotations.NullMarked;

/**
 * MojangsonPathによって投げられるアクセス例外。
 * @see MojangsonPath
 */
@NullMarked
public final class MojangsonPathUnableToAccessException extends Exception {
    MojangsonPathUnableToAccessException(String message) {
        super(message);
    }
}
