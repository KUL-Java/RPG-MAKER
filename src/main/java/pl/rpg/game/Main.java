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


    private static void summonMinions() {
        pathFindingMinion = callPathFindingMinionMinion();
        thoughtDestinyMinion = callThoughtDestinyMinion();
        mindReaderMinion = callMindReaderMinion();
        motionMinion = callMotionMinionMinion();
        heraldMinion = callHeraldMinionMinion();
        gateKeeperMinion = callGateKeeperMinionMinion();
        curiousMinion = callCuriousMinion();

    }
    public static void main(String[] args) throws IOException {
        summonMinions();

        Player player = new Player(WorldGenerator.getStartingLocation());

        motionMinion.assignPlayer(player);
        motionMinion.assignPlayer(player);

        while (true) {
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
