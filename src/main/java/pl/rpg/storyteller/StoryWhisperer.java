package pl.rpg.storyteller;

import pl.rpg.storyteller.minions.chornicles.Chronicle;
import pl.rpg.storyteller.minions.chornicles.Library;
import pl.rpg.storyteller.minions.chornicles.Page;

public class StoryWhisperer extends StoryTeller {

  public StoryWhisperer(Library library) {
    super(library);
  }

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
      System.out.println(bookInsignia);
    }
  }

  @Override
  protected void closeTheBook() {
    String storyWhispererQuote = "Finally the end, It was a bit embarrassing";
    System.out.println(storyWhispererQuote);
    String stringBuilder =
        bookInsignia + newLiner + frame + theEnd + frame + newLiner + bookInsignia + newLiner;
    System.out.println(stringBuilder);
  }
}
