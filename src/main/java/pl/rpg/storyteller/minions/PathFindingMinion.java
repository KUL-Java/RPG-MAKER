package pl.rpg.storyteller.minions;

import pl.rpg.world.Exits;
import pl.rpg.world.Location;

public class PathFindingMinion {
  private static PathFindingMinion pathFindingMinion = new PathFindingMinion();

  private PathFindingMinion() {}

  public static PathFindingMinion callMinion() {
    return pathFindingMinion;
  }

  public Location studyAncientMaps(Location location, Exits exits) {

    if(exits.equals(Exits.NOWHERE)){
      throw new NullPointerException();
    }
      return location.getLocationOn(exits);
  }
}
