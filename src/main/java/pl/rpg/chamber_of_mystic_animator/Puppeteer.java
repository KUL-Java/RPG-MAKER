package pl.rpg.chamber_of_mystic_animator;

import pl.rpg.game.Location;
import pl.rpg.game.Player;

public class Puppeteer {
    private static Puppeteer puppeteer = new Puppeteer();
    private Player player;

    private Puppeteer(){

    }
    public static Puppeteer callMinion(){
        return puppeteer;
    }
    public void movePlayer(Location location){
        player.setCurrentLocation(location);
    }
    public void assignPlayer(Player player){
        this.player = player;
    }
}
