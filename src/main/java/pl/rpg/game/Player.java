package pl.rpg.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private String description;
    private int hp;

}
