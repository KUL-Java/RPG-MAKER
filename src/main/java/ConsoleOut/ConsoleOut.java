package ConsoleOut;

import Main.History;
import Main.Way;

import java.util.Map;
import java.util.Set;

public class ConsoleOut implements UserWriter {
    private int delay;
    private String color;

    public ConsoleOut(int delay, String color) {
        this.color = ColorCoder.getColorCode(color);
        this.delay = delay;
    }

    public void writeHistory(History history) {
        writeStory(history.getHistory());
        writeWays(history.getWays());
    }

    void writeStory(String text) {
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

    public void writeWays(Map<Character, Way> ways) {
        Set<Map.Entry<Character, Way>> entrySet = ways.entrySet();
        for (Map.Entry<Character, Way> entry : entrySet) {
            try {
                Thread.sleep(10 * delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(color + "[" + entry.getKey() + "] " + entry.getValue());
        }
    }
}
