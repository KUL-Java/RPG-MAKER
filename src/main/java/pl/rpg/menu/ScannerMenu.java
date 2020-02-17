package pl.rpg.menu;

import java.util.Scanner;

public class ScannerMenu {
    Scanner scanener = new Scanner(System.in);

    public int takeNumber() {
        return scanener.nextInt();
    }
    public String takeColor(){
        return scanener.next().toUpperCase();
    }
}
