package pl.rpg.storyteller.minions;

import pl.rpg.game.HeroesGuild;
import pl.rpg.game.Player;

public class PlayerCreatorMinion {
  private static PlayerCreatorMinion playerCreatorMinion = new PlayerCreatorMinion();
  private HeroesGuild heroesGuild;

  private PlayerCreatorMinion() {}

  public static PlayerCreatorMinion callMinion() {
    return playerCreatorMinion;
  }
  public void assignHeadHuntersGuild(HeroesGuild heroesGuild){
    this.heroesGuild = heroesGuild;
  }
  public Player getHeroeByName(String name){
    return heroesGuild.getHeroByName(name);
  }

}
