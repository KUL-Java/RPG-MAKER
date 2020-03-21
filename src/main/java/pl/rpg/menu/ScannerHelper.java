package pl.rpg.menu;

import java.util.Scanner;

public class ScannerHelper {

    private static Scanner scanner;

    public ScannerHelper(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public static int takeNumber() {
        return scanner.nextInt();
    }

    public static String takeColor() {
        return scanner.next().toUpperCase();
    }
}