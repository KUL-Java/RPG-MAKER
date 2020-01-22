package pl.rpg.console;


import pl.rpg.game.History;
import pl.rpg.game.UserWriter;
import pl.rpg.game.Way;

import java.util.Map;

public class ConsoleOut implements UserWriter {
    private int delay;
    private String color;

    public ConsoleOut(int delay, String color) {
        this.color = hexToRGB(color);
        this.delay = delay;
    }

    private static String hexToRGB(String colorHex) {
        colorHex = colorHex.trim();
        int length = colorHex.length();
        return "\u001B[38:2:" + Integer.parseInt(colorHex.substring(length - 6, length - 4), 16) + ":" + Integer.parseInt(colorHex.substring(length - 4, length - 2), 16) + ":" + Integer.parseInt(colorHex.substring(length - 2, length), 16) + "m";
    }

    public void writeHistory(History history) {
        writeStory(history.getHistory());
        writeWays(history.getWays());
    }

    private void writeStory(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(color + c);
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    private void writeWays(Map<Character, Way> ways) {
        for (Map.Entry<Character, Way> entry : ways.entrySet()) {
            try {
                Thread.sleep(10 * delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(color + "[" + entry.getKey() + "] " + entry.getValue());
        }
    }
}
