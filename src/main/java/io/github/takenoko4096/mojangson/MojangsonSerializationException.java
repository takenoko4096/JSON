package io.github.takenoko4096.mojangson;

import org.jspecify.annotations.NullMarked;

/**
 * MojangsonSerializerによって投げられるシリアライゼーション例外。
 * @see MojangsonSerializer
 */
@NullMarked
public class MojangsonSerializationException extends RuntimeException {
    protected MojangsonSerializationException(String message) {
        super(message);
    }

    protected MojangsonSerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
