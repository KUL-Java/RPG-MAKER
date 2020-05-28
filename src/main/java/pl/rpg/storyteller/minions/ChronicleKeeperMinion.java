package pl.rpg.storyteller.minions;

import lombok.Data;
import pl.rpg.game.Chronicle;
import pl.rpg.game.Library;
@Data
public class ChronicleKeeperMinion {
  private ChronicleKeeperMinion chronicleKeeperMinion = new ChronicleKeeperMinion();
  private Library library;

  private ChronicleKeeperMinion() {}

  public ChronicleKeeperMinion callMinion() {
    return chronicleKeeperMinion;
  }

  public Chronicle bringChronicleByItsName(String name) {
    return this.library.getChronicleByItsName(name);
  }
}
