package ConsoleOut;

import java.util.Scanner;

public class ConsoleOutPreferences {
    private int delay;
    private String color;

    public ConsoleOutPreferences() {
        System.out.println("What color do you want the text to be?");
        Scanner scanner=new Scanner(System.in);
        color =scanner.nextLine().toUpperCase();
        System.out.println("What delay do you want to be?");
        delay=scanner.nextInt();
    }

    public int getDelay() {
        return delay;
    }

    public String getColor() {
        return color;
    }
}
