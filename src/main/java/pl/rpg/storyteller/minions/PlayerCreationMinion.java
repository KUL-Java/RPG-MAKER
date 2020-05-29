package pl.rpg.storyteller.minions;

public class PlayerCreationMinion {
  private static PlayerCreationMinion playerCreationMinion = new PlayerCreationMinion();

  private PlayerCreationMinion() {}

  public static PlayerCreationMinion callMinion() {
    return playerCreationMinion;
  }
}
