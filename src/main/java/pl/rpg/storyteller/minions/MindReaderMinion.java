package pl.rpg.storyteller.minions;

import java.util.Scanner;

public class MindReaderMinion {
  private MindReaderMinion mindReaderMinion = new MindReaderMinion();
  private Scanner scanner = new Scanner(System.in);

  private MindReaderMinion() {}

  public MindReaderMinion callMinion() {
    return this.mindReaderMinion;
  }

  String getPlayerWill() {
    return scanner.nextLine();
  }
}
