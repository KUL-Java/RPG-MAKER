package pl.rpg.world.locations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.rpg.world.locations.interactions.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class PointOfInterest {
    private String name;
    List<Command> commands = new ArrayList<>();
    Map<String, String> properties = new HashMap<>();


    public PointOfInterest(String name) {
        this.name = name;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void interact(String command) {
        commands.stream()
                .filter(x -> x.getName().equals(command))
                .map(Command::getInteraction)
                .findFirst().orElse((item) -> System.out.println("Nie rozumiem.")).interact(this);
    }
}
