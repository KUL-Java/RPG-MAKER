package pl.rpg.game;

import java.util.Scanner;

public class UserReader {
    private final static char[] CORRECT_LETTERS = {'W', 'S', 'N', 'E'};

    Scanner scanner;

    public UserReader() {
        scanner = new Scanner(System.in);
    }


    public char fetchChoice() {
        String input;
        input = scanner.nextLine();
        if (input.length() == 1) {
            char formatedInput = input.toUpperCase().charAt(0);
            for (char letter : CORRECT_LETTERS) {
                if (formatedInput == letter) {
                    return formatedInput;
                }
            }
        }
        throw new IllegalArgumentException();
    }//ma pobrać poprawny input (poprawny komunikat), podać input jeszcze raz.
}

