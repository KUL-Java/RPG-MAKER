package pl.rpg.game;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {
    private String name;
    private String description;
    private Set<Exits> exits = new HashSet<>();
    private Set<LinkedLocation> linkedLocations = new HashSet<>();

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void linkLocations(Exits exit, Location destinyLocation) {
        final LinkedLocation linkedLocation = new LinkedLocation(exit, destinyLocation);
        this.addLocation(linkedLocation);
        this.exits.add(linkedLocation.getExit());
    }

    public Location getLocationOn(Exits exit) {
        return linkedLocations.stream().filter(linkedLocation -> linkedLocation.getExit().equals(exit)).map(LinkedLocation::getLocation).findFirst().get();
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
