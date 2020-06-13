package pl.rpg.menu;

import java.awt.*;

import static pl.rpg.menu.Option.printOptions;

public class MainMenu {
  private UserUtils userUtils;
  private static final String DEFAULT_COLOR = Color.BLACK.toString();
  private static final int DEFAULT_DELAY = 100;

  public MainMenu(UserUtils userUtils) {
    this.userUtils = userUtils;
  }

  public void controlLoop() {

    Option choice;
    do {
      printOptions();
      choice = Option.createFromInt(UserUtils.takeNumber());
      UserUtils.nextL();
      if (choice == Option.EXIT) {
       userUtils.printExit();
      } else if (choice == Option.NEW_GAME) {
        // Game game = new Game(color, delay);
      } else if (choice == Option.SETTINGS) {
        printSettings();
      } else {
       userUtils.wrongChoice();
      }
    } while (choice != Option.EXIT);
  }

  private void printSettings() {
    System.out.println("Settings");
  }


}
