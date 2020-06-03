package pl.rpg.storyteller.minions;

import pl.rpg.world.locations.Exit;

public class ThoughtDestinyMinion {
  private static ThoughtDestinyMinion destinyFinderMinion = new ThoughtDestinyMinion();

  private ThoughtDestinyMinion() {}

  public static ThoughtDestinyMinion callThoughtDestinyMinion() {
    return destinyFinderMinion;
  }

  public double interpretThoughtAsFraction(String thought) {
    try {
      return Double.parseDouble(thought);
    } catch (NumberFormatException e) {
      return 0.0;
    }
  }

  public int interpretThoughtAsNumber(String thought) {
    try {
      return Integer.parseInt(thought);
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public Exit interpretThoughtAsExit(String thought) {
    try {
      return Exit.valueOf(thought);
    } catch (IllegalArgumentException e) {
      return Exit.NOWHERE ;
    }
  }

  public String interpretThoughtAsSentence(String thought) {
    return thought;
  }
}
