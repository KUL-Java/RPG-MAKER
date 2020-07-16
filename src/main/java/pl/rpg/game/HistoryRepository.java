package pl.rpg.game;

import java.util.Collections;

public class HistoryRepository {

    private Histories histories;

    public HistoryRepository() {
        histories = new Histories();
    }

    public History getFirstHistory() {
        return histories.getHistory(0);
    }

    public History fetchHistory(int id) {
        return new History("END", Collections.emptyMap());
    }

}
