package pl.rpg.world.locations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Exit {
    NORTH("NORTH"),
    EAST("EAST"),
    WEST("WEST"),
    SOUTH("SOUTH"),
    OUT("OUT"),
    IN("IN"),
    DOORS("DOORS"),
    NOWHERE("Nie ma takiego wyjścia!");

    String optionName;

}
