package io.github.takenoko4096.json;

/**
 * JSONPathによって投げられるアクセス例外。
 * @see JSONPath
 */
public class JSONPathUnableToAccessException extends Exception {
    protected JSONPathUnableToAccessException(String message) {
        super(message);
    }
}
