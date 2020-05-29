package pl.rpg.storyteller.minions;

import pl.rpg.game.WorldOfFloatingIslands;
import pl.rpg.game.Location;

public class CreatorOfFloatingIslandMinion {
  private static CreatorOfFloatingIslandMinion creatorOfFloatingIslandMinion =
      new CreatorOfFloatingIslandMinion();
  private WorldOfFloatingIslands worldOfFloatingIslands;

  private CreatorOfFloatingIslandMinion() {}

  public static CreatorOfFloatingIslandMinion callMinion() {
    return creatorOfFloatingIslandMinion;
  }

  public void putLocationInScrools(Location location) {
    worldOfFloatingIslands.addLocation(location);
  }

  public Location markLocationOnMap(String locationName) {
    return worldOfFloatingIslands.summonTheFloatingIslandByName(locationName);
  }

  public void establishPortalWithWorldOfFloatingIslands(
      WorldOfFloatingIslands worldOfFloatingIslands) {
    this.worldOfFloatingIslands = worldOfFloatingIslands;
  }
}
