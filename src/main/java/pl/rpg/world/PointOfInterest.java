package pl.rpg.world;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.rpg.world.interactions.Command;
import pl.rpg.world.interactions.Interaction;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PointOfInterest {
    private String name;
    private String description;
    List<Command> commands = new ArrayList<>();

    public PointOfInterest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public String interact(String command) {
        return commands.stream()
                .filter(x -> x.getName().equals(command))
                .map(Command::getInteraction)
                .findFirst().orElse(() -> "Nie rozumiem.")
                .interact();

    }
}
