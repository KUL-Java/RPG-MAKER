package pl.rpg.game;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Histories {

        List<History> histories = new ArrayList<>();

    public Histories() {



        String tekst = "U see big classroom with many chairs. On almost every chair sits one student. In" +
                " this moment you recalled that today is exam day! In whole classroom only one chair is free." +
                " Bad news. It's the chair in front of your professor. What will you do young student? ";
        Map<Character, Way> mapa = new TreeMap<>();
        mapa.put('W', new Way("Sit in this chair and try to pass this exam (You didn't attend this lecture)",
                2));
        mapa.put('S', new Way("Pretend that you have made a mistake and run as fast as you can",
                3));
        History history = new History(tekst, mapa);
        histories.add(history);
    }

    public History getHistory(int id) { return histories.get(id); }
}