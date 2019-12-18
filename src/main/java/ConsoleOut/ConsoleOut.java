package ConsoleOut;
import Main.History;

public class ConsoleOut implements UserWriter {
    private TextWriter textWriter;
    private WaysWriter waysWriter;
    private int delay;
    private String color;
    public ConsoleOut(int delay, String color) {
        this.textWriter = new TextWriter();
        this.waysWriter = new WaysWriter();
        color=color;
        delay = delay;
    }
    public void writeHistory(History history){
        textWriter.Write(history.getHistory(), delay, color);
        waysWriter.Write(history.getWays(), delay, color);
    }
}
