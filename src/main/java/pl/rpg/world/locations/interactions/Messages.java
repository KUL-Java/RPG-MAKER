package pl.rpg.world.locations.interactions;

import java.util.*;

public class Messages {
    public static List<String> messages = new ArrayList<>();

    static {
        final String rysunek = "          .--------._\n" +
                "         (`--'       `-.\n" +
                "          `.______      `.\n" +
                "       ___________`__     \\\n" +
                "    ,-'           `-.\\     |\n" +
                "   //                \\|    |\\\n" +
                "  (`  .'~~~~~---\\     \\'   | |\n" +
                "   `-'           )     \\   | |\n" +
                "      ,---------' - -.  `  . '\n" +
                "    ,'             `%`\\`     |\n" +
                "   /                      \\  |\n" +
                "  /     \\-----.         \\    `\n" +
                " /|  ,_/      '-._            |\n" +
                "(-'  /           /            `     \n" +
                ",`--<           |        \\     \\\n" +
                "\\ |  \\         /%%             `\\\n" +
                " |/   \\____---'--`%        \\     \\\n" +
                " |    '           `               \\\n" +
                " |\n" +
                "  `--.__\n" +
                "        `---._______\n" +
                "                    `.\n" +
                "                      \\";
        messages.add(rysunek);
    }
}
