package pl.rpg.storyteller.minions.fiends;

import pl.rpg.world.Location;
import pl.rpg.world.PointOfInterest;

import java.util.List;

public class CuriousMinion {
  private static CuriousMinion curiousMinion = new CuriousMinion();
  private Location location;

  private CuriousMinion() {}

  public static CuriousMinion callMinion() {
    return curiousMinion;
  }

  public void assignLocation(Location location) {
    this.location = location;
  }

  public String interact(String command, String objectName) {
    PointOfInterest desiredPointOfInterest = getDesiredPointOfInterest(objectName);
    if (desiredPointOfInterest != null) {
      return desiredPointOfInterest.interact(command);
    }
    return "Something went wrong";
  }

  private PointOfInterest getDesiredPointOfInterest(String objectName) {
    List<PointOfInterest> pointsOfInterest = location.getPointsOfInterests();
    for (PointOfInterest pointOfInterest : pointsOfInterest) {
      if (pointOfInterest.getName().equals(objectName)) {
        return pointOfInterest;
      }
    }
    return null;
  }
}
