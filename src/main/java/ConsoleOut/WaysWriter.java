package ConsoleOut;

import Main.Way;
import java.util.Map;

public class WaysWriter {
    public void Write(Map<Character, Way> ways, int delay, String color){
        for (Character name: ways.keySet()){
            try {
                Thread.sleep(10*delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String letter = name.toString();
            Way way = ways.get(name);
            System.out.println(color+"["+letter + "] " + way);
        }
    }
}