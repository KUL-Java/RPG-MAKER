package pl.rpg.menu;

import java.util.Scanner;

public class UserUtils {

  private static Scanner scanner = new Scanner(System.in);

  public void printExit() {
    System.out.println("Your game is over!");
  }

  public static int takeNumber() {
    return scanner.nextInt();
  }

  public static String takeColor() {
    return scanner.next().toUpperCase();
  }

  public static void nextL() {
    scanner.nextLine();
  }

  public void wrongChoice() {
      System.out.println("Wrong choice. Try again!");
  }
}
