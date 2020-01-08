package pl.rpg.game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game( new HistoryRepository(), new UserReader(), new UserWriter());
        game.runGame();
    }
}
