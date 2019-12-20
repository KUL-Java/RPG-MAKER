package Main;

import java.util.Map;

public class History {

    private String history;
    private Map<Character, Way> ways;

    public History(String history, Map<Character, Way> ways) {
        this.history = history;
        this.ways = ways;
    }

    public String getHistory() {
        return history;
    }

    public Map<Character, Way> getWays() {
        return ways;
    }
}
