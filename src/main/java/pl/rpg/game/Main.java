package pl.rpg.game;

import pl.rpg.storyteller.StoryTeller;
import pl.rpg.storyteller.StoryYeller;
import pl.rpg.storyteller.minions.*;
import pl.rpg.storyteller.minions.CuriousMinion;
import pl.rpg.storyteller.minions.fiends.LibraryFiend;
import pl.rpg.world.Exits;
import pl.rpg.world.Location;
import pl.rpg.world.PointOfInterest;
import pl.rpg.world.World;
import pl.rpg.world.interactions.Command;

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
    LibraryFiend libraryFiend = new LibraryFiend();
    StoryTeller storyTeller = new StoryYeller();
    Library library = new Library();
    library.addChronicle(LibraryFiend.getChroniclesFromJson());


    World world = new World(storyTeller, libraryFiend, library);
    world.teleportLocations(prepareWorld());
    Player player = new Player(world.getLocationByName("Karczma"));
    world.play(player);
  }

  public static List<Location> prepareWorld() {
    List<Location> locations = new ArrayList<>();
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
            }));

    karczma.addPointsOfInterest(table);
    System.out.println(table.getCommands());
    locations.add(karczma);
    locations.add(alkierz);
    locations.add(podwoje);
    return locations;
  }
}
