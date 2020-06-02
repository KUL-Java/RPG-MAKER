package pl.rpg.storyteller.minions;

import lombok.Data;
import pl.rpg.storyteller.minions.chornicles.Chronicle;
import pl.rpg.storyteller.minions.chornicles.Library;
@Data
public class ChronicleKeeperMinion {
  private static ChronicleKeeperMinion chronicleKeeperMinion = new ChronicleKeeperMinion();
  private Library library;

  private ChronicleKeeperMinion() {
  }

  public static ChronicleKeeperMinion callChronicleKeeperMinion() {
    return chronicleKeeperMinion;
  }
  public void giveMinionKeyToLibrary(Library library){
    this.library = library;
  }

  public Chronicle bringChronicleByItsName(String name) {
    return this.library.getChronicleByItsName(name);
  }
}
