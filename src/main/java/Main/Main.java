package Main;

import console.output.ConsolePrinter;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //This code is as shitty as it can be. Don't roast me yet please
        Scanner scanner = new Scanner(System.in);
        ConsolePrinter consolePrinter = new ConsolePrinter();
        
        consolePrinter.println("U see big classroom with many chairs. On almost every chair sits one student. In this moment you recalled that today is exam day! In whole classroom only one chair is free. ");
        consolePrinter.println("Bad news. It's the chair in front of your professor. What will you do young student? ");

        LinkedHashMap<String, String> choices = new LinkedHashMap<>();
        choices.put("W", "Sit in this chair and try to pass this exam (You didn't attend this lecture)");
        choices.put("S", "Pretend that you have made a mistake and run as fast as you can");
        consolePrinter.printChoices(choices);
        
        String choice = scanner.nextLine();
        if (choice.equals("w")) {
            Random random = new Random();
            int score = random.nextInt(101);
            if (score >= 90) {
                consolePrinter.println("When you sat on last chair, professor gave you your exam... And went to the end of the classroom!");
                consolePrinter.println("After you have read first question you have realized that it's impossible to pass... but then you have looked right!");
                consolePrinter.println("This one friend that every time knows the answers is sitting next to you!!!! ");
                Thread.sleep(2000);
                consolePrinter.println("TWO DAYS LATER");
                consolePrinter.println("The results are on email... YOU HAVE A!");
            } else if (score >= 60) {
                consolePrinter.println("When you sat on last chair, professor gave you your exam... And went to the end of the classroom!");
                consolePrinter.println("Good thing that you have your phone in the pocket. You can do it!");
                Thread.sleep(2000);
                consolePrinter.println("TWO DAYS LATER");
                consolePrinter.println("The results are on email... You passed! ... but with bad grade");
            } else {
                consolePrinter.println("When you sat on last chair, professor gave you your exam... And have standed near your position to the end of the exam.");
                Thread.sleep(2000);
                consolePrinter.println("TWO DAYS LATER");
                consolePrinter.println("The results are on email... You hope that you won't have to pay a lot of money for repeating this year...");
            }
        } else if (choice.equals("s")) {
            consolePrinter.println("You have ran away in fear. Unfortunately there was no other chance to pass this exam... You have to repeat this year ;/");
        } else {
            consolePrinter.println("You are completely stupid");
        }

        consolePrinter.println("TEST");
        consolePrinter.println("TEST2");
        consolePrinter.println("TEST 3 ");
    }
}
