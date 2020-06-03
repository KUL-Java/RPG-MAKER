package pl.rpg.world.pregen;

import pl.rpg.world.locations.Exit;
import pl.rpg.world.locations.Location;
import pl.rpg.world.locations.interactions.Interaction;
import pl.rpg.world.locations.poi.PointOfInterest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LocationHelper {
    private LocationHelper() {
    }


    public static Location INN;
    public static Location BEDROOM;

    public static void initialize() {
        //INN
        INN = new Location("Karczma", "Duszna, przydrożna karczma pod Upitym Kucykiem. \nPoza stołem nie ma tu chyba nic ciekawego.");
        BEDROOM = new Location("Sypialnia", "Prosta, niewyróżniająca się niczym izba sypialna");

        final PointOfInterest table = new PointOfInterest();

        table.addOrChangeProperty("content", "trzy pełne kufle piwa i misa z grochówka");

        final List<String> drinkTriggers = Arrays.asList("łyknij piwa z kufla", "napij się piwa", "łyknij piwa");
        final Interaction drink = x -> {
            if (x.getProperty("isFlipped").equals("true")) {
                System.out.println("Raczej nie znajdziesz przy tym stole zdatnego trunku...");
                return;
            }

            System.out.println("Pociągasz solidny łyk z dębowego kufla, stojącego wprost naprzeciw ciebie.");

        };
        table.addInteraction(drinkTriggers, drink);


        final List<String> lookTriggers = Arrays.asList("obejrzyj stół", "popatrz na stół", "spójrz na stół");
        final Interaction look = x -> {
            if (x.getProperty("isFlipped").equals("true")) {
                System.out.println("Przewrócony stół, leżący w obrzydliwiej mieszaninie piwa z gulaszem na kamiennej posadzce karczmy.");
                return;
            }
            System.out.println(String.format("Stary, typowy karczemny stół, który zapewne nie raz wylądował na ziemi podczas" +
                    " pijackiej bijatyki.\nLeżą na nim %s.", x.getProperty("content")));

        };
        table.addInteraction(lookTriggers, look);


        final List<String> flipTriggers = Arrays.asList("wywróć stół", "przewróć stół", "kopnij stół");
        final Interaction flip = x -> {
            System.out.println("Gwałtownym ruchem wywracasz karczemny stół, wylewając na podłogę " +
                    "zawartość kufli,\nwywołując tym samym niemale zamieszanie w izbie.");
            x.addOrChangeProperty("isFlipped", "true");
        };
        table.addInteraction(flipTriggers, flip);
        INN.addPointsOfInterest("table", table);
        INN.linkLocations(Exit.NORTH, BEDROOM);
        BEDROOM.linkLocations(Exit.SOUTH,INN);
    }

}
