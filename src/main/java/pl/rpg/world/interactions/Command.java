package pl.rpg.world.interactions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
