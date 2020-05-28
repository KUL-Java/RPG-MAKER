package pl.rpg.storyteller;

import pl.rpg.game.Chronicle;
import pl.rpg.game.Location;
import pl.rpg.storyteller.minions.MindReaderMinion;
import pl.rpg.storyteller.minions.ThoughtDestinyMinion;

public abstract class StoryTeller {
  protected MindReaderMinion mindReaderMinion;
  protected ThoughtDestinyMinion thoughtDestinyMinion;
  protected Location currentLocation;
  //TODO player creator minion
  //
  public void describeLocation() {
    System.out.println(currentLocation.getDescription());
  }
  public void readFromChronicle(Chronicle chronicle){
    System.out.println(chronicle.turnPage());
  }
}
