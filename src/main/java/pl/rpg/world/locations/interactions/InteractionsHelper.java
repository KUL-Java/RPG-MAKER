package pl.rpg.world.locations.interactions;

import pl.rpg.world.locations.interactions.Interaction;

public class InteractionsHelper {

    public static final Interaction INVALID_INTERACTION = x -> {
        System.out.println("Nie rozumiem...");
    };


    private InteractionsHelper() {
    }
}
