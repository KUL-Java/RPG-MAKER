package pl.rpg.world;

import lombok.*;
import pl.rpg.world.interactions.Command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {
  private String name;
  private String description;
  private Set<Exits> exits = new HashSet<>();
  private Set<LinkedLocation> linkedLocations = new HashSet<>();
  private List<PointOfInterest> pointsOfInterests = new ArrayList<>();

  public Location(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void addPointsOfInterest(PointOfInterest pointOfInterest) {
    pointsOfInterests.add(pointOfInterest);
  }

  public void linkLocations(Exits exit, Location destinyLocation) {
    final LinkedLocation linkedLocation = new LinkedLocation(exit, destinyLocation);
    this.addLocation(linkedLocation);
    this.exits.add(linkedLocation.getExit());
  }

  public Location getLocationOn(Exits exit) {
    return linkedLocations.stream()
        .filter(linkedLocation -> linkedLocation.getExit().equals(exit))
        .map(LinkedLocation::getLocation)
        .findFirst()
        .orElse(this);
  }

  private void addLocation(LinkedLocation linkedLocation) {
    linkedLocations.add(linkedLocation);
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Set<Exits> getExits() {
    return exits;
  }

  @Setter
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  private class LinkedLocation {
    Exits exit;
    Location location;

    public Exits getExit() {
      return exit;
    }

    @Override
    public String toString() {
      return String.format("LinkedLocation{%s - %s}", this.location.name, this.exit);
    }
  }
}
