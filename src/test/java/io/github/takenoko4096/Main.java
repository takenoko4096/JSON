import io.github.takenoko4096.json.JSONParser;
import io.github.takenoko4096.json.JSONPath;
import io.github.takenoko4096.json.JSONValueTypes;

void main() {
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
}
