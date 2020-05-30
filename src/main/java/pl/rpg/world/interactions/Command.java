package pl.rpg.world.interactions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Command {
    private String name;
    private Interaction interaction;
}
