import io.github.takenoko4096.mojangson.MojangsonParser;
import io.github.takenoko4096.mojangson.MojangsonPath;
import io.github.takenoko4096.mojangson.MojangsonSerializer;
import io.github.takenoko4096.mojangson.values.MojangsonCompound;
import io.github.takenoko4096.nbt.NbtFile;

void main() {
    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
    System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));

    var a = new MojangsonCompound();
    a.set(MojangsonPath.of("a.b.c.d"), 1);

    System.out.println(a);
}
