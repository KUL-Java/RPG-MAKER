package pl.rpg.storyteller.minions;

import pl.rpg.world.Exits;
import pl.rpg.world.locations.Location;

public class PathFindingMinion {
  private static PathFindingMinion pathFindingMinion = new PathFindingMinion();

  private PathFindingMinion() {}

  public static PathFindingMinion callPathFindingMinionMinion() {
    return pathFindingMinion;
  }

  public Location studyAncientMaps(Location location, Exits exits) {

    if(exits.equals(Exits.NOWHERE)){
      throw new NullPointerException();
    }
      return location.getLocationOn(exits);
  }
}
