package pl.rpg.menu;

import pl.rpg.game.Game;

import java.awt.*;
import java.util.Scanner;

public class MainMenu {
    private ScannerHelper scanner;
    private String color = Color.BLACK.toString();
    private int delay = 100;


    public void showMenu() {

        int choice = scanner.takeNumber();
        do {
            System.out.println("New game - press 1");
            System.out.println("Settings - press 2");
            System.out.println("Quit - press 3");

            if (choice == 3) {
                System.out.println("Your game is over!");
            } else if (choice == 1) {
                // Game game = new Game(color, delay);

            } else if (choice == 2) {
                System.out.println("Enter color:");
                color = scanner.takeColor();

                System.out.println("Enter delay:");
                delay = scanner.takeNumber();
            }

        } while (choice == 2);
    }
}