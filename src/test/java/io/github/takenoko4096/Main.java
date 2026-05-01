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

    abstract class A<S extends Number> {
        abstract void f(S o);
    }

    class B extends A<Integer> {
        @Override
        void f(Integer o) {

        }
    }

    System.out.println(s.get(JSONPath.of("key.array[{\"foo\":[\"baz\"]}].foo[0]"), JSONValueTypes.STRING));
}
