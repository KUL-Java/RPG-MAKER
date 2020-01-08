package pl.rpg.menu;

import pl.rpg.game.Game;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int choice;
    String color;
    int delay;
    do {
      System.out.println("New game - press 1");
      System.out.println("Settings - press 2");
      System.out.println("Quit - press 3");
      choice = scanner.nextInt();

      if (choice == 3) {
        System.out.println("Your game is over!");
      } else if (choice == 1) {
//         Game game = new Game(color, delay);

      } else if (choice == 2) {
        System.out.println("Enter color:");
        color = scanner.next().toUpperCase();

        System.out.println("Enter delay:");
        delay = scanner.nextInt();
      }

    } while (choice == 2);
  }
}
