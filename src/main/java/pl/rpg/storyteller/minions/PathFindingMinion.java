package pl.rpg.storyteller.minions;

import pl.rpg.game.Exits;
import pl.rpg.game.Location;
import java.util.List;

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

    System.out.println("Przechodzisz na " + exits.getOptionName());
      return location.getLocationOn(exits);
  }
}
