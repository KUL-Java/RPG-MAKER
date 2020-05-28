package pl.rpg.storyteller;

import pl.rpg.storyteller.StoryTeller;

public class StoryYeller extends StoryTeller {

    @Override
    public void describeLocation() {
    System.out.println(currentLocation.getDescription().toUpperCase() + "!!!!!!");
    }
}
