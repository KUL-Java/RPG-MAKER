package pl.rpg.storyteller;

import pl.rpg.game.Chronicle;
import pl.rpg.game.Page;

public class StoryYeller extends StoryTeller {

  @Override
  public void describeLocation() {
    System.out.println(currentLocation.getDescription().toUpperCase() + "!!!!!!");
  }

  @Override
  public void readFromChronicle(Chronicle chronicle) {
    Page page = chronicle.turnPage();
    if (page == null) {
      closeTheBook();
    } else {
      System.out.println(page);
      System.out.println(bookInsignia);
    }
  }

  protected void closeTheBook() {
    String storyYellerQuote =
        "*Cough* *Cough* I've been screaming for all this time, I need to drink something *Cough* *Cough";
    System.out.println(storyYellerQuote);
    String stringBuilder =
        bookInsignia + newLiner + frame + "THE END" + frame + newLiner + bookInsignia + newLiner;
    System.out.println(stringBuilder);
  }
}
