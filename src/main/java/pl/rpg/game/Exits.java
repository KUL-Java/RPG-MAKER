package pl.rpg.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Exits {
    NORTH("N"),
    EAST("E"),
    WEST("W"),
    SOUTH("S"),
    OUT("Out"),
    IN("In");

    String optionName;

}
