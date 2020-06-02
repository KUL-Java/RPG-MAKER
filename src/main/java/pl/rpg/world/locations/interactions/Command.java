package pl.rpg.world.locations.interactions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Command {
    // słownik // mapa do tłumcaczen
    private String name;
    private Interaction interaction;

}
