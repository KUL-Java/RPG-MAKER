package pl.rpg.storyteller;

import pl.rpg.game.Chronicle;
import pl.rpg.game.Page;

public class StoryWhisperer extends StoryTeller {

  @Override
  public void describeLocation() {
    System.out.println("pssst... " + currentLocation.getDescription() + "...");
  }

  @Override
  public void readFromChronicle(Chronicle chronicle) {
    Page page = chronicle.turnPage();
    if (page == null) {
      closeTheBook();
    } else {
      System.out.println("pssst..." + page + "...");
    }
  }

  @Override
  protected void closeTheBook() {
    String newLiner = "\n";
    String bookInsignia = "^...^...^...^...^...^...^...^...^...^";
    String frame = "|";
    String storyWhispererQuote = "Finally end, It was a bit embarrassing";
    System.out.println(storyWhispererQuote);
    String stringBuilder =
        bookInsignia + newLiner + frame + "THE END" + frame + newLiner + bookInsignia + newLiner;
    System.out.println(stringBuilder);
  }
}
