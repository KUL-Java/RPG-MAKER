package pl.rpg.storyteller.minions;

public class ThoughtDestinyMinion {
  private ThoughtDestinyMinion destinyFinderMinion = new ThoughtDestinyMinion();

  private ThoughtDestinyMinion() {}

  public ThoughtDestinyMinion callMinion() {
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

  public String interpreteThoughtAsSentence(String thought) {
    return thought;
  }
}
