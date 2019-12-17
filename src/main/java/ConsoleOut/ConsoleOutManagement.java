package ConsoleOut;
import java.util.Map;

public class ConsoleOutManagement {
    private StringShow stringShow;
    private WaysShow waysShow;
    private int delay;
    private String color;
    public ConsoleOutManagement() {
        ConsoleOutPreferences consoleOutPreferences=new ConsoleOutPreferences();
        this.stringShow = new StringShow();
        this.waysShow = new WaysShow();
        color=new ColorCode(consoleOutPreferences.getColor()).getCodedColor();
        delay = consoleOutPreferences.getDelay();
    }
    public void showStory(String story, Map<Character, String> ways)
    {
        stringShow.ShowString(story, delay, color);
        waysShow.showWays(ways, delay, color);
    }
}
