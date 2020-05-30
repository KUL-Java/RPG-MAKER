package pl.rpg.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Exits {
    NORTH("Północ"),
    EAST("Wschód"),
    WEST("Zachód"),
    SOUTH("Południe"),
    OUT("Wyjście"),
    IN("In"),
    DOORS("Drzwi"),
    NOWHERE("Nie ma takiego wyjścia!");

    String optionName;

}
