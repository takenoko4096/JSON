import io.github.takenoko4096.mojangson.MojangsonParser;
import io.github.takenoko4096.mojangson.MojangsonPath;
import io.github.takenoko4096.mojangson.values.MojangsonCompound;
import io.github.takenoko4096.nbt.NbtFile;

void main() {
    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
    System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));

    final NbtFile file = new NbtFile("src/test/resources/player.dat");

    System.out.println(file.isCompressed());

    final MojangsonCompound compound = file.readAsCompressed();
    compound.set(MojangsonPath.of("equipment.mainhand"), MojangsonParser.compound(
        """
        {
            id: 'minecraft:carrot_on_a_stick',
            count: 1,
            components: {
                'minecraft:enchantments': {
                    'minecraft:sharpness': 10
                }
            }
        }
        """
    ));

    file.writeAsCompressed(compound);
}
