package ConsoleOut;

import Main.Way;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class WaysWriter {
    public void Write(Map<Character, Way> ways, int delay, String color){
        Set<Entry<Character, Way>> entrySet=ways.entrySet();
        for(Entry<Character, Way> entry:entrySet){
            try {
                Thread.sleep(10*delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(color+"["+entry.getKey()+"] "+entry.getValue());
        }
    }
}