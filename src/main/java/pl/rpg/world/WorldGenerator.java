package pl.rpg.world;

import lombok.extern.java.Log;
import pl.rpg.world.locations.Location;
import pl.rpg.world.locations.PointOfInterest;
import pl.rpg.world.locations.interactions.Command;

@Log
public class WorldGenerator {



    public static Location getStartingLocation() {

        log.info("GENERATING LOCATIONS");
        Location karczma = new Location("Karczma", "Brudna, zatechła karczma Pod Upitym Kucykiem. " +
                "\nJedyna interesująca tu rzeczą zdaję się być stół.");
        Location alkierz =
                new Location("Alkierz", "Odgrodzona, ciasna klitka, z dala od zgiełku głównej sali");
        Location podwoje =
                new Location("Podwoje", "Przed głównym wejsciem do karczmy Pod Upitym Kucykiem");

        log.info("GENERATING POINTS OF INTEREST");
        PointOfInterest table =
                new PointOfInterest(
                        "table");

        log.info("GENERATING INTERACTIONS");
        table.addCommand(
                new Command(
                        "obejrzyj stół",
                        (item) -> {

                            if("true".equals(item.getProperties().get("isBurned"))){
                                System.out.println("Stary, spopielony do reszty stół");
                            } else {
                                System.out.println("Karczemny stół, który widział zapewne niejedna bijatyke");
                            }
                        }));

        table.addCommand(
                new Command(
                        "spal stół",
                        (item) -> {
                            System.out.println("Potężnych zakleciem kuli ognia nie trafiasz w stól, ale w karczmarza, natomiast z nudów przewróciłeś swieczkę");
                            item.getProperties().put("isBurned","true");
                        }

                ));

        log.info("FILLING LOCATIONS WITH POINTS OF INTEREST");
        karczma.addPointsOfInterest(table);


        log.info("LINKING LOCATIONS");
        karczma.linkLocations(Exits.NORTH, alkierz);
        alkierz.linkLocations(Exits.SOUTH, karczma);
        karczma.linkLocations(Exits.OUT, podwoje);
        podwoje.linkLocations(Exits.DOORS, karczma);


        return karczma;
    }


}
