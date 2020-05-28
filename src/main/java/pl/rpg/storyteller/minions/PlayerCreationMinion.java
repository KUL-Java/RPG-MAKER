package pl.rpg.storyteller.minions;

public class PlayerCreationMinion {
    private static PlayerCreationMinion playerCreationMinion = new PlayerCreationMinion();

    private PlayerCreationMinion(){

    }

    public PlayerCreationMinion callMinion(){
        return playerCreationMinion;
    }
}
