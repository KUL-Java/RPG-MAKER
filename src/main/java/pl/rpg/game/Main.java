package pl.rpg.game;

import org.omg.PortableInterceptor.LOCATION_FORWARD;
import pl.rpg.storyteller.minions.*;
import pl.rpg.storyteller.minions.CuriousMinion;
import pl.rpg.storyteller.minions.fiends.SetUpFiend;
import pl.rpg.world.Exits;
import pl.rpg.world.Location;
import pl.rpg.world.PointOfInterest;
import pl.rpg.world.World;
import pl.rpg.world.interactions.Command;
import pl.rpg.world.interactions.Messages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    PathFindingMinion pathFindingMinion = PathFindingMinion.callMinion();
    ThoughtDestinyMinion thoughtDestinyMinion = ThoughtDestinyMinion.callMinion();
    MindReaderMinion mindReaderMinion = MindReaderMinion.callMinion();
    MotionMinion motionMinion = MotionMinion.callMinion();
    HeraldMinion heraldMinion = HeraldMinion.callMinion();
    GateKeeperMinion gateKeeperMinion = GateKeeperMinion.callMinion();
    CuriousMinion curiousMinion = CuriousMinion.callMinion();
    SetUpFiend setUpFiend = new SetUpFiend();
    World world = new World("Stary świat");

    Location karczma =
        new Location(
            "Karczma",
            "Brudna, zatechła karczma Pod Upitym Kucykiem. "
                + "\nJedyna interesująca tu rzeczą zdaję się być stół.");
    Location alkierz =
        new Location("Alkierz", "Odgrodzona, ciasna klitka, z dala od zgiełku głównej sali");
    Location podwoje =
        new Location("Podwoje", "Przed głównym wejsciem do karczmy Pod Upitym Kucykiem");

    karczma.linkLocations(Exits.NORTH, alkierz);
    alkierz.linkLocations(Exits.SOUTH, karczma);
    karczma.linkLocations(Exits.OUT, podwoje);
    podwoje.linkLocations(Exits.DOORS, karczma);

    PointOfInterest table = new PointOfInterest("table", "Stare stół");

    table.addCommand(
        new Command(
            "obejrzyj stół",
            (item) -> {
              System.out.println(table.getDescription());
            }));

    table.addCommand(
        new Command(
            "przewróć stół",
            (item) -> {
              System.out.println("Przewracasz stół w pizdu");
              item.setDescription("Stary wyjebany stół");
              //                            item.setState("Ilosc kufli", "0");

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

  public static List<Location> prepareWorld() {
    List<Location> locations = new ArrayList<>();
    PointOfInterest studnia = new PointOfInterest("Studnia", "Głęboka studnia na niewielkim placu");
    studnia.addCommand(
        new Command(
            "skocz na główke",
            (x) -> {
              System.out.println("Lecisz na główke i właśnie zaraz skręcisz sobie kark");
            }));
    studnia.addCommand(
        new Command(
            "obejrzyj studnie",
            (x) -> {
              System.out.println("No... normalna studnia, nie?");
            }));
    PointOfInterest kram =
        new PointOfInterest("Kram w centrum", "Kram handlarza, który ma wszystko drogie");
    kram.addCommand(
        new Command(
            "Krycz na handlarza",
            (x) -> {
              System.out.println("Paaaaanie co tak drogo!?");
            }));
    Location przedmiesciaAltdorf =
        new Location(
            "Przedmieścia Altdorf",
            "Przedmieścia brudnego, jednak majestatycznego miasta imperium");
    przedmiesciaAltdorf.addPointsOfInterest(studnia);
    Location centrumAltdorf = new Location("Altdorf Centrum", "Tłoczne i głośne miasto");
    przedmiesciaAltdorf.linkLocations(Exits.IN, centrumAltdorf);
    centrumAltdorf.linkLocations(Exits.OUT, przedmiesciaAltdorf);
    przedmiesciaAltdorf.addPointsOfInterest(studnia);
    centrumAltdorf.addPointsOfInterest(kram);
    locations.add(przedmiesciaAltdorf);
    locations.add(centrumAltdorf);
    return locations;
  }
}
