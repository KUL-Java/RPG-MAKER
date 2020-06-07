package pl.rpg.world.locations;

import lombok.*;
import pl.rpg.world.locations.poi.PointOfInterest;
import pl.rpg.world.locations.poi.PointsOfInterestHelper;

import java.util.*;

@AllArgsConstructor
@ToString
@Data
public class Location {
    private String name;
    private String description;
    private Map<Exit, Location> linkedLocations = new HashMap<>();
    private Map<String, PointOfInterest> pointsOfInterests = new HashMap<>();

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Set<Exit> getExits() {
        return linkedLocations.keySet();
    }

    public Location getLinkedLocation(Exit exit) {
        return linkedLocations.getOrDefault(exit, this);
    }

    public void linkLocations(Exit exit, Location destinyLocation) {
        linkedLocations.put(exit, destinyLocation);
    }

    public void addPointsOfInterest(String key, PointOfInterest pointOfInterest) {
        pointsOfInterests.put(name, pointOfInterest);
    }

    private PointOfInterest getPointOfInterest(String name) {
        return pointsOfInterests.getOrDefault(name, PointsOfInterestHelper.INVALID_POI);
    }
}
