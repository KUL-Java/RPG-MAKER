package pl.rpg.storyteller.minions;

import pl.rpg.game.LinkedLocation;
import pl.rpg.game.Location;
import java.util.List;

public class PathFindingMinion {
  private static PathFindingMinion pathFindingMinion = new PathFindingMinion();

  private PathFindingMinion() {}

  public static PathFindingMinion callMinion() {
    return pathFindingMinion;
  }

  public Location studyAncientMaps(Location location, String direction) {
    List<LinkedLocation> possibleWays = location.getLinkedLocations();
    for (LinkedLocation possibleWay : possibleWays) {
      if (possibleWay.getExit().equals(direction)) {
        return possibleWay.getLinkedLocation();
      }
    }
    return null;
  }
}
