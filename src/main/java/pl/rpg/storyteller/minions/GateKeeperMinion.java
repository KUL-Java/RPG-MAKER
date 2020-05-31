package pl.rpg.storyteller.minions;

import pl.rpg.world.Exits;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GateKeeperMinion {
  private static GateKeeperMinion gateKeeperMinion = new GateKeeperMinion();
  private List<String> reservedCommands =
      Arrays.stream(Exits.values()).map(Exits::getOptionName).collect(Collectors.toList());

  private GateKeeperMinion() {}

  public static GateKeeperMinion callMinion() {
    return gateKeeperMinion;
  }

  public boolean isExit(String will) {
    return reservedCommands.contains(will);
  }
}
