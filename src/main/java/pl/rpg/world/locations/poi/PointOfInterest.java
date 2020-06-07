package pl.rpg.world.locations.poi;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import pl.rpg.exceptions.InvalidInteractionTriggerException;
import pl.rpg.world.locations.interactions.Interaction;
import pl.rpg.world.locations.interactions.InteractionsHelper;

import java.util.*;

@NoArgsConstructor
@Data
@Log
public class PointOfInterest {

    private Map<String, Interaction> interactions = new HashMap<>();
    private Map<String, String> properties = new HashMap<>();

    public void interact(String trigger) {
        interactions
                .getOrDefault(trigger, InteractionsHelper.INVALID_INTERACTION)
                .interact(this);


    }

    public void addInteraction(Collection<String> triggers, Interaction interaction) {
        for (String trigger : triggers
        ) {
            addInteraction(trigger, interaction);
        }
    }

    public void addOrChangeProperty(String property, String value) {
        if (this.properties.containsKey(property)) {
            logReplacement(property, value);
        } else {
            logCreation(property, value);
        }
        properties.put(property, value);
    }

    public String getProperty(String property) {
        return properties.getOrDefault(property, PropertyHelper.INVALID_PROPERTY);
    }

    private void addInteraction(String trigger, Interaction interaction) {
        if (Objects.isNull(trigger) || trigger.isEmpty()) {
            throw new InvalidInteractionTriggerException("Interaction trigger cannot be null nor empty");
        }

        interactions.put(trigger, interaction);
    }

    private void logCreation(String property, String value) {
        log.info(String.format("Created %s property with value: %s",
                property, value));
    }

    private void logReplacement(String property, String value) {
        log.info(String.format("Property %s present, replacing present value: %s with: %s",
                property, properties.get(property), value));
    }
}


//TODO
/*
 * 1. miec mozliwosc grania w swiecie gry
 * 2. miec mozliwosc serializacji kodu do plikow json/xml/inne
 * 3. miec mozliwosc wczytania calej przygody z json/xml/inne
 * 4. miec mozliwosc dodania plikow przy pomocy schematu json/xml/inne
 * 5. miec mozliwosc wyklikania pliku json/xml/inne przez GUI
 */