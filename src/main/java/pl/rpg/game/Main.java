package pl.rpg.game;

import pl.rpg.storyteller.minions.UserReader;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new HistoryRepository(), new UserReader(), new ConsoleOut(10, "RED"));
        game.runGame();
    }
}
