package pl.rpg.game;

import lombok.Getter;
import pl.rpg.storyteller.minions.MindReaderMinion;
import pl.rpg.world.locations.Exit;
import pl.rpg.world.locations.Location;
import pl.rpg.world.locations.interactions.InteractionsHelper;
import pl.rpg.world.locations.poi.PointOfInterest;
import pl.rpg.world.locations.poi.PointsOfInterestHelper;

@Getter
public class Player {
    private MindReaderMinion mindReaderMinion = MindReaderMinion.callMindReaderMinion();
    private Location currentLocation;

    public Player(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void act() {
        final String command = getCommand();
        interpretCommand(command);
    }

    private String getCommand() {
        return mindReaderMinion.getPlayerWill();
    }

    private void move(Exit exit) {
        this.currentLocation = currentLocation.getLinkedLocation(exit);
    }

    private void interpretCommand(String command) {
        try {
            final Exit exit = Exit.valueOf(command);
            move(exit);
        } catch (Exception e) {
            System.out.println();
            tryInteracting(command);
        }
    }

    private void tryInteracting(String command) {
        for (PointOfInterest poi : this.getCurrentLocation().getPointsOfInterests().values()
        ) {
            if (poi.getInteractions().containsKey(command)) {
                poi.interact(command);
                return;
            }
        }
        InteractionsHelper.INVALID_INTERACTION.interact(PointsOfInterestHelper.INVALID_POI);
    }

}
