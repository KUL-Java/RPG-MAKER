package pl.rpg.storyteller.minions;

import lombok.Data;
import pl.rpg.game.Chronicle;
import pl.rpg.game.Library;
@Data
public class ChronicleKeeperMinion {
  private static ChronicleKeeperMinion chronicleKeeperMinion = new ChronicleKeeperMinion();
  private Library library;

  private ChronicleKeeperMinion() {
  }

  public static ChronicleKeeperMinion callMinion() {
    return chronicleKeeperMinion;
  }
  public void giveMinionKeyToLibrary(Library library){
    this.library = library;
  }

  public Chronicle bringChronicleByItsName(String name) {
    return this.library.getChronicleByItsName(name);
  }
}
