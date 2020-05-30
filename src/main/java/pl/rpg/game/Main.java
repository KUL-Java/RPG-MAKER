package pl.rpg.game;

import pl.rpg.storyteller.minions.*;
import pl.rpg.world.Exits;
import pl.rpg.world.Location;
import pl.rpg.world.PointOfInterest;
import pl.rpg.world.interactions.Command;

import java.io.IOException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {

    PathFindingMinion pathFindingMinion = PathFindingMinion.callMinion();
    ThoughtDestinyMinion thoughtDestinyMinion = ThoughtDestinyMinion.callMinion();
    MindReaderMinion mindReaderMinion = MindReaderMinion.callMinion();
    MotionMinion motionMinion = MotionMinion.callMinion();
    HeraldMinion heraldMinion = HeraldMinion.callMinion();
    GateKeeperMinion gateKeeperMinion = GateKeeperMinion.callMinion();

    Location karczma = new Location("Karczma", "Brudna, zatechła karczma Pod Upitym Kucykiem");
    Location alkierz =
        new Location("Alkierz", "Odgrodzona, ciasna klitka, z dala od zgiełku głównej sali");
    Location podwoje =
        new Location("Podwoje", "Przed głównym wejsciem do karczmy Pod Upitym Kucykiem");

    karczma.linkLocations(Exits.NORTH, alkierz);
    alkierz.linkLocations(Exits.SOUTH, karczma);
    karczma.linkLocations(Exits.OUT, podwoje);
    podwoje.linkLocations(Exits.DOORS, karczma);

    PointOfInterest table =
        new PointOfInterest(
            "table", "Plain old table, which probably seen more than one bar brawl");

    table.addCommand(
        new Command(
            "spójrz na stół",
            () -> {
              return "Na cholere drązysz temat";
            }));

    System.out.println(table.getCommands());
    Player player = new Player(karczma);
    motionMinion.assignPlayer(player);

    while (true) {
      heraldMinion.announce(String.format("--%s--", player.getCurrentLocation().getName()));
      heraldMinion.announce(player.getCurrentLocation().getDescription());
      heraldMinion.announce(String.valueOf(player.getCurrentLocation().getExits()));
      final String playerWill = mindReaderMinion.getPlayerWill();
      if(gateKeeperMinion.readPlayerWill(playerWill)){
          final Exits desiredDirection = thoughtDestinyMinion.interpretThoughtAsExit(playerWill);
          try {
              motionMinion.moveAssignedPlayer(
                      pathFindingMinion.studyAncientMaps(player.getCurrentLocation(), desiredDirection));
          } catch (NullPointerException e) {
              heraldMinion.announce(desiredDirection.getOptionName());
          }
      }else {
        System.out.println("Well, sumthin went wong");
      }

    }
  }
}
