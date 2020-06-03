package pl.rpg.storyteller.minions;

import pl.rpg.world.locations.Exit;
import pl.rpg.world.locations.Location;

public class PathFindingMinion {
  private static PathFindingMinion pathFindingMinion = new PathFindingMinion();

  private PathFindingMinion() {}

  public static PathFindingMinion callPathFindingMinionMinion() {
    return pathFindingMinion;
  }

  public Location studyAncientMaps(Location location, Exit exit) {

    if(exit.equals(Exit.NOWHERE)){
      throw new NullPointerException();
    }
      return location.getLinkedLocation(exit);
  }
}
