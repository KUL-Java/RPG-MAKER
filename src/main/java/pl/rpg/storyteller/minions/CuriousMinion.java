package pl.rpg.storyteller.minions;

import pl.rpg.world.locations.Location;
import pl.rpg.world.locations.PointOfInterest;
import pl.rpg.world.locations.interactions.Command;

import java.util.List;

public class CuriousMinion {
    private static CuriousMinion curiousMinion = new CuriousMinion();
    private Location location;

    private CuriousMinion() {
    }

    public static CuriousMinion callCuriousMinion() {
        return curiousMinion;
    }

    public void assignLocation(Location location) {
        this.location = location;
    }


    public String interact(String playerCommand) {
        String intractableObject = findObjectToPlayWith(playerCommand);
        PointOfInterest desiredPointOfInterest = getDesiredPointOfInterest(intractableObject);
        if (desiredPointOfInterest != null) {
             desiredPointOfInterest.interact(playerCommand);
             return desiredPointOfInterest.getDescription();
        }
        return "Something went wrong";
    }

    private String findObjectToPlayWith(String playerCommand) {
        final List<PointOfInterest> pointsOfInterests = location.getPointsOfInterests();
        for (PointOfInterest poi : pointsOfInterests
        ) {
            for (Command command : poi.getCommands()
            ) {
                if (command.getName().equals(playerCommand)) {
                    return poi.getName();
                }
            }
        }
        return "None";
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
