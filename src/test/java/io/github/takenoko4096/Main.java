import io.github.takenoko4096.json.JSONParser;
import io.github.takenoko4096.json.JSONPath;
import io.github.takenoko4096.json.JSONValueTypes;
import io.github.takenoko4096.mojangson.MojangsonParser;
import io.github.takenoko4096.mojangson.MojangsonPath;
import io.github.takenoko4096.mojangson.MojangsonValueTypes;

void main() {
    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
    System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));

    IO.println("Hello, World!");

    var s = JSONParser.object(
        """
        {
            "key": {
                "array": [
                    {
                        "foo": ["bar", "baz"]
                    }
                ]
            }
        }
        """
    );

    System.out.println(s.get(JSONPath.of("key.array[{\"foo\":[\"baz\"]}].foo[0]"), JSONValueTypes.STRING));

    var s2 = MojangsonParser.compound(
        """
        {
            "key": {
                "array": [
                    {
                        "foo": ["bar", "baz"]
                    }
                ]
            }
        }
        """
    );

    System.out.println(s2.get(MojangsonPath.of("key.array[{\"foo\":[\"baz\"]}].foo[0]"), MojangsonValueTypes.STRING));
}
