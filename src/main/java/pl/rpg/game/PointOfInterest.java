package pl.rpg.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.rpg.world.interactions.Interaction;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PointOfInterest {
    private String name;
    private String description;
    List<Interaction> possibleInteractions = new ArrayList<>();

    public void addInteractionWithObject(Interaction interaction){
        possibleInteractions.add(interaction);
    }
}
