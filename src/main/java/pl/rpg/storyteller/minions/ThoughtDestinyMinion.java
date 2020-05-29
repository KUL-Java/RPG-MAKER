package pl.rpg.storyteller.minions;

public class ThoughtDestinyMinion {
  private static ThoughtDestinyMinion destinyFinderMinion = new ThoughtDestinyMinion();

  private ThoughtDestinyMinion() {}

  public static ThoughtDestinyMinion callMinion() {
    return destinyFinderMinion;
  }

  public double interpreteThoughtAsFraction(String thought) {
    try {
      return Double.parseDouble(thought);
    } catch (NumberFormatException e) {
      return 0.0;
    }
  }

  public int interpreteThoughtAsNumber(String thought) {
    try {
      return Integer.parseInt(thought);
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public String interpretThoughtAsSentence(String thought) {
    return thought;
  }
}
