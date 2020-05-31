package pl.rpg.game;

import pl.rpg.storyteller.minions.*;
import pl.rpg.storyteller.minions.CuriousMinion;
import pl.rpg.world.Exits;
import pl.rpg.world.Location;
import pl.rpg.world.PointOfInterest;
import pl.rpg.world.interactions.Command;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    PathFindingMinion pathFindingMinion = PathFindingMinion.callMinion();
    ThoughtDestinyMinion thoughtDestinyMinion = ThoughtDestinyMinion.callMinion();
    MindReaderMinion mindReaderMinion = MindReaderMinion.callMinion();
    MotionMinion motionMinion = MotionMinion.callMinion();
    HeraldMinion heraldMinion = HeraldMinion.callMinion();
    GateKeeperMinion gateKeeperMinion = GateKeeperMinion.callMinion();
    CuriousMinion curiousMinion = CuriousMinion.callMinion();

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
            "table", "");

    table.addCommand(
        new Command(
            "obejrzyj stół",
            () -> {
              return "Prosty, stary stół, który prawdopodobnie ma za sobą niejedna karczemną bijatykę.";
            }));


    karczma.addPointsOfInterest(table);

    System.out.println(table.getCommands());
    Player player = new Player(karczma);
    motionMinion.assignPlayer(player);

    while (true) {
      System.out.println();
      heraldMinion.announce(String.format("--%s--", player.getCurrentLocation().getName()));
      heraldMinion.announce(player.getCurrentLocation().getDescription());
      heraldMinion.announce(String.valueOf(player.getCurrentLocation().getExits()));
      final String playerWill = mindReaderMinion.getPlayerWill();
      if (gateKeeperMinion.isExit(playerWill)) {
        final Exits desiredDirection = thoughtDestinyMinion.interpretThoughtAsExit(playerWill);
        try {
          motionMinion.moveAssignedPlayer(
              pathFindingMinion.studyAncientMaps(player.getCurrentLocation(), desiredDirection));
        } catch (NullPointerException e) {
          heraldMinion.announce(desiredDirection.getOptionName());

        }
      } else {
          curiousMinion.assignLocation(player.getCurrentLocation());
        System.out.println(curiousMinion.interact(playerWill));
      }
    }
  }
}
