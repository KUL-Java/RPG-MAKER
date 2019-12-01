package Main;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //This code is as shitty as it can be. Don't roast me yet please
        Scanner scanner = new Scanner(System.in);
        System.out.println("U see big classroom with many chairs. On almost every chair sits one student. In this moment you recalled that today is exam day! In whole classroom only one chair is free. ");
        System.out.println("Bad news. It's the chair in front of your professor. What will you do young student? ");
        System.out.println("[W] - Sit in this chair and try to pass this exam (You didn't attend this lecture)");
        System.out.println("[S] - Pretend that you have made a mistake and run as fast as you can");
        String choice = scanner.nextLine();
        if (choice.equals("w")) {
            Random random = new Random();
            int score = random.nextInt(101);
            if (score >= 90) {
                System.out.println("When you sat on last chair, professor gave you your exam... And went to the end of the classroom!");
                System.out.println("After you have read first question you have realized that it's impossible to pass... but then you have looked right!");
                System.out.println("This one friend that every time knows the answers is sitting next to you!!!! ");
                Thread.sleep(2000);
                System.out.println("TWO DAYS LATER");
                System.out.println("The results are on email... YOU HAVE A!");
            } else if (score >= 60) {
                System.out.println("When you sat on last chair, professor gave you your exam... And went to the end of the classroom!");
                System.out.println("Good thing that you have your phone in the pocket. You can do it!");
                Thread.sleep(2000);
                System.out.println("TWO DAYS LATER");
                System.out.println("The results are on email... You passed! ... but with bad grade");
            } else {
                System.out.println("When you sat on last chair, professor gave you your exam... And have standed near your position to the end of the exam.");
                Thread.sleep(2000);
                System.out.println("TWO DAYS LATER");
                System.out.println("The results are on email... You hope that you won't have to pay a lot of money for repeating this year...");
            }
        } else if (choice.equals("s")) {
            System.out.println("You have ran away in fear. Unfortunately there was no other chance to pass this exam... You have to repeat this year ;/");
        } else {
            System.out.println("You are completely stupid");
        }

        System.out.println("TEST");
    }
}
