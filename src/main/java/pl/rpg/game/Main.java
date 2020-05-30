package pl.rpg.game;


import pl.rpg.storyteller.StoryTeller;
import pl.rpg.storyteller.StoryWhisperer;
import pl.rpg.storyteller.StoryYeller;
import pl.rpg.storyteller.minions.ChronicleKeeperMinion;
import pl.rpg.storyteller.minions.MindReaderMinion;
import pl.rpg.storyteller.minions.PathFindingMinion;
import pl.rpg.storyteller.minions.ThoughtDestinyMinion;
import pl.rpg.storyteller.minions.fiends.LibraryFiend;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        PathFindingMinion pathFindingMinion = PathFindingMinion.callMinion();
        ThoughtDestinyMinion thoughtDestinyMinion = ThoughtDestinyMinion.callMinion();
        MindReaderMinion mindReaderMinion = MindReaderMinion.callMinion();

        Location karczma = new Location("Karczma", "Brudna, zatechła karczma Pod Upitym Kucykiem");
        Location alkierz = new Location("Alkierz", "Odgrodzona, ciasna klitka, z dala od zgiełku głównej sali");
        Location podwoje = new Location("Podwoje", "Przed głównym wejsciem do karczmy Pod Upitym Kucykiem");

        karczma.linkLocations(Exits.NORTH, alkierz);
        alkierz.linkLocations(Exits.SOUTH, karczma);
        karczma.linkLocations(Exits.OUT, podwoje);
        podwoje.linkLocations(Exits.DOORS, karczma);

        Player player = new Player(karczma);


        while (true) {
            System.out.println(String.format("--%s--", player.getCurrentLocation().getName()));
            System.out.println(player.getCurrentLocation().getDescription());
            System.out.println(player.getCurrentLocation().getExits());
            final String playerWill = mindReaderMinion.getPlayerWill();
            final Exits desiredDirection = thoughtDestinyMinion.interpretThoughtAsExit(playerWill);

            try {
                player.setCurrentLocation(pathFindingMinion.studyAncientMaps(player.getCurrentLocation(), desiredDirection));
            } catch (NullPointerException e) {
                System.out.println(desiredDirection.getOptionName());
            }


        }

    }
}
