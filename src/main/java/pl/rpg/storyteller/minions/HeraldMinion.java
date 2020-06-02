package pl.rpg.storyteller.minions;

public class HeraldMinion {
    private static HeraldMinion heraldMinion = new HeraldMinion();

    private HeraldMinion(){}

    public static HeraldMinion callHeraldMinionMinion(){
        return heraldMinion;
    }

    public void announce(String message){
        System.out.println(message);
    }
}
