package pl.rpg.menu;

import pl.rpg.console.ConsoleOut;

import java.util.Scanner;

public class MainMenu {

    public void MainMenu() {
        ScannerMenu scanner = new ScannerMenu();
        //int choice=scanner.takeNumber();
        String color=ColorsRGB.BLACK;
        int delay=1000;
        do {
            System.out.println("New game - press 1");
            System.out.println("Settings - press 2");
            System.out.println("Quit - press 3");
          //  choice = scanner.nextInt();

            if (scanner.takeNumber() == 3) {
                System.out.println("Your game is over!");
            } else if (scanner.takeNumber() == 1) {
              //  ConsoleOut consol = new ConsoleOut();

            } else if (scanner.takeNumber() == 2) {
                System.out.println("Enter color:");
                color = scanner.takeColor();

                System.out.println("Enter delay:");
                delay = scanner.takeNumber();
            }

        } while (scanner.takeNumber() == 2);
    }
}
