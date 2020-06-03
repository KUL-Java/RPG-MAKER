package pl.rpg.storyteller.minions;

import pl.rpg.world.locations.Exit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GateKeeperMinion {
  private static GateKeeperMinion gateKeeperMinion = new GateKeeperMinion();
  private List<String> reservedCommands =
      Arrays.stream(Exit.values()).map(Exit::getOptionName).collect(Collectors.toList());

  private GateKeeperMinion() {}

  public static GateKeeperMinion callGateKeeperMinionMinion() {
    return gateKeeperMinion;
  }

  public boolean isExit(String will) {
    return reservedCommands.contains(will);
  }
}
