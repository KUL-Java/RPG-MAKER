package pl.rpg.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.rpg.world.Location;

@Getter
@AllArgsConstructor
public class Player {
    private Location currentLocation;

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
