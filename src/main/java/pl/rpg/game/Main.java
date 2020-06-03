package pl.rpg.game;

import pl.rpg.storyteller.minions.*;
import pl.rpg.world.pregen.LocationHelper;

import static pl.rpg.storyteller.minions.GateKeeperMinion.callGateKeeperMinionMinion;
import static pl.rpg.storyteller.minions.HeraldMinion.callHeraldMinionMinion;
import static pl.rpg.storyteller.minions.MindReaderMinion.callMindReaderMinion;
import static pl.rpg.storyteller.minions.PathFindingMinion.callPathFindingMinionMinion;
import static pl.rpg.storyteller.minions.ThoughtDestinyMinion.callThoughtDestinyMinion;


public class Main {

    private static PathFindingMinion pathFindingMinion;
    private static ThoughtDestinyMinion thoughtDestinyMinion;
    private static MindReaderMinion mindReaderMinion;
    private static HeraldMinion heraldMinion;
    private static GateKeeperMinion gateKeeperMinion;

    private static void summonMinions() {
        pathFindingMinion = callPathFindingMinionMinion();
        thoughtDestinyMinion = callThoughtDestinyMinion();
        mindReaderMinion = callMindReaderMinion();
        heraldMinion = callHeraldMinionMinion();
        gateKeeperMinion = callGateKeeperMinionMinion();
    }

    public static void main(String[] args) {

        summonMinions();

        LocationHelper.initialize();
        Player player = new Player(LocationHelper.INN);


        while (true) {
            heraldMinion.announce("");
            heraldMinion.announce(String.format("--%s--", player.getCurrentLocation().getName()));
            heraldMinion.announce(player.getCurrentLocation().getDescription());
            heraldMinion.announce("Dostrzegasz tu możliwe wyjścia: \n" + player.getCurrentLocation().getExits());
            player.act();

        }
    }
}
