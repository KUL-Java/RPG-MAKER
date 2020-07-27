package pl.rpg.game;

import pl.rpg.console.ConsoleOut;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new HistoryRepository(), new UserReader(), new ConsoleOut(10, "RED"));
        game.runGame();

        UserReader user= new UserReader();

    }
}
