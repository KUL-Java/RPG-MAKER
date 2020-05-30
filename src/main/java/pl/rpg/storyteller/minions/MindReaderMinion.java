package pl.rpg.storyteller.minions;

import java.util.Scanner;

public class MindReaderMinion {
  private static MindReaderMinion mindReaderMinion = new MindReaderMinion();
  private Scanner scanner = new Scanner(System.in);

  private MindReaderMinion() {}

  public static MindReaderMinion callMinion() {
    return mindReaderMinion;
  }

  public String getPlayerWill() {
    return scanner.nextLine();
  }
}
