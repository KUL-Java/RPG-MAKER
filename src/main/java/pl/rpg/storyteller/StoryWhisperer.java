package pl.rpg.storyteller;

import pl.rpg.storyteller.StoryTeller;

public class StoryWhisperer extends StoryTeller {

    @Override
    public void describeLocation() {
    System.out.println("pssst... " + currentLocation.getDescription() + "...");
    }
}
