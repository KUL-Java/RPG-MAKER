package pl.rpg.storyteller;

import pl.rpg.game.Chronicle;
import pl.rpg.game.Location;
import pl.rpg.game.Page;
import pl.rpg.storyteller.minions.MindReaderMinion;
import pl.rpg.storyteller.minions.ThoughtDestinyMinion;

public abstract class StoryTeller {
  protected MindReaderMinion mindReaderMinion;
  protected ThoughtDestinyMinion thoughtDestinyMinion;
  Location currentLocation;
  // TODO player creator minion

  public void describeLocation() {
    System.out.println(currentLocation.getDescription());
  }

  public void readFromChronicle(Chronicle chronicle) {
    Page page = chronicle.turnPage();
    if (page == null) {
      closeTheBook();
    } else {
      System.out.println(page);
    }
  }

  public void openTheBook(Chronicle chronicle) {
    String newLiner = "\n";
    String bookInsignia = "^...^...^...^...^...^...^...^...^...^";
    String frame = "|";
    String stringBuilder =
        bookInsignia
            + newLiner
            + frame
            + chronicle.name.toUpperCase()
            + frame
            + newLiner
            + bookInsignia
            + newLiner;
    System.out.println(stringBuilder);
  }

  protected void closeTheBook() {
    String newLiner = "\n";
    String bookInsignia = "^...^...^...^...^...^...^...^...^...^";
    String frame = "|";
    String stringBuilder =
        bookInsignia + newLiner + frame + "THE END" + frame + newLiner + bookInsignia + newLiner;
    System.out.println(stringBuilder);
  }
}
