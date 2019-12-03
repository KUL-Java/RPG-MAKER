package console.output;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ConsolePrinter {

    private final int DEFAULT_CHAR_DELAY_MS = 8;
    private final String CHOICE_COLOR = ConsoleColors.GREEN;
    private final String TEXT_COLOR = ConsoleColors.WHITE;


    public void print(String text) {
        print(text, TEXT_COLOR);
    }

    public void print(String text, String colorCode) {
        System.out.print(colorCode);
        printDelayed(text);
        System.out.print(ConsoleColors.RESET);
    }

    public void println(String text) {
        println(text, TEXT_COLOR);
    }

    public void println(String text, String colorCode) {
        print(text, colorCode);
        println();
    }

    public void printChoices(Map<String, String> choiceToDescription) {
        for (Map.Entry<String, String> choice : choiceToDescription.entrySet()) {
            printSingleChoice(choice.getKey(), choice.getValue());
        }
    }

    private void printSingleChoice(String choice, String description) {
        println("[" + choice + "] - " + description, CHOICE_COLOR);
    }

    private void printDelayed(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);

            try {
                TimeUnit.MILLISECONDS.sleep(DEFAULT_CHAR_DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void println() {
        System.out.println();
    }
}
