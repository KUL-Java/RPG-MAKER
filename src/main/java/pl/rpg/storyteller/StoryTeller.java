package pl.rpg.storyteller;

import pl.rpg.storyteller.minions.chornicles.Chronicle;
import pl.rpg.world.locations.Location;
import pl.rpg.storyteller.minions.chornicles.Page;
import pl.rpg.storyteller.minions.MindReaderMinion;
import pl.rpg.storyteller.minions.ThoughtDestinyMinion;

public abstract class StoryTeller {
  protected MindReaderMinion mindReaderMinion;
  protected ThoughtDestinyMinion thoughtDestinyMinion;
  final String bookInsignia = "^...^...^...^...^...^...^...^...^...^";
  final String frame = "|";
  final String newLiner = "\n";
  final String theEnd = "THE END";
  Location currentLocation;

  public void describeLocation() {
    System.out.println(currentLocation.getDescription());
  }

  public void readFromChronicle(Chronicle chronicle) {
    Page page = chronicle.turnPage();
    if (page == null) {
      closeTheBook();
    } else {
      System.out.println(page);
      System.out.println(bookInsignia);
    }
  }

  public void openTheBook(Chronicle chronicle) {
    String stringBuilder =
        bookInsignia
            + newLiner
            + frame
            + chronicle.getName().toUpperCase()
            + frame
            + newLiner
            + bookInsignia
            + newLiner;
    System.out.println(stringBuilder);
  }

  protected void closeTheBook() {
    final String theEnd = "THE END";
    String stringBuilder =
        bookInsignia + newLiner + frame + theEnd + frame + newLiner + bookInsignia + newLiner;
    System.out.println(stringBuilder);
  }
}
