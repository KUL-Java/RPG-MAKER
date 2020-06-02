package pl.rpg.storyteller.minions.chornicles;

import java.util.ArrayList;
import java.util.List;

public class Library {
  private List<Chronicle> chronicles = new ArrayList<>();

  public Chronicle getChronicleByItsName(String name) {
    for (Chronicle chronicle : chronicles) {
      if (chronicle.getName().equals(name)) {
        return chronicle;
      }
    }
    return new Chronicle("Untold story");
  }

  public void addChronicle(Chronicle newChronicle) {
    this.chronicles.add(newChronicle);
  }
}
