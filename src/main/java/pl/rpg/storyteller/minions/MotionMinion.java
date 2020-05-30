package pl.rpg.storyteller.minions;

import pl.rpg.world.Location;
import pl.rpg.game.Player;

public class MotionMinion {
    private static MotionMinion motionMinion = new MotionMinion();
    private Player assignedPlayer;

      private MotionMinion(){

    }
    public static MotionMinion callMinion(){
        return motionMinion;
    }
    public void moveAssignedPlayer(Location location){
        assignedPlayer.setCurrentLocation(location);
    }
    public void assignPlayer(Player player){
        this.assignedPlayer = player;
    }
}
