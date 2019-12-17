package ConsoleOut;

import java.util.Map;

public class WaysShow {
    public void showWays(Map<Character, String> ways, int delay, String color){
        for (Character name: ways.keySet()){
            try {
                Thread.sleep(10*delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String letter = name.toString();
            String way = ways.get(name);
            System.out.println(color+"["+letter + "] " + way);
        }
    }
}