package pl.rpg.game;

import pl.rpg.storyteller.StoryTeller;
import pl.rpg.storyteller.StoryYeller;
import pl.rpg.storyteller.minions.*;
import pl.rpg.storyteller.minions.CuriousMinion;
import pl.rpg.world.Exits;
import pl.rpg.world.WorldGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static PathFindingMinion pathFindingMinion;
    static ThoughtDestinyMinion thoughtDestinyMinion;
    static MindReaderMinion mindReaderMinion;
    static MotionMinion motionMinion;
    static HeraldMinion heraldMinion;
    static GateKeeperMinion gateKeeperMinion;
    static CuriousMinion curiousMinion;

    public static void main(String[] args) throws IOException {
        summonMinions();

        Player player = new Player(WorldGenerator.getStartingLocation());

        motionMinion.assignPlayer(player);

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
