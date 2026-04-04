package com.gmail.takenokoii78;

import com.gmail.takenokoii78.mojangson.MojangsonParser;
import com.gmail.takenokoii78.mojangson.MojangsonPath;

public class Main {
    static void main() {
        System.out.println("Hello world!");

        final var c = MojangsonParser.compound(
            """
            {
                foo: bar,
                ints: [I; 0, 1, 2, 3],
                comp: {
                    key: 0xffffff
                }
            }
            """
        );

        System.out.println(c.getTypeOf(MojangsonPath.of("comp.key")));
    }
}
