package pl.rpg.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HeroesGuild {
  List<Player> listOfHeroes = new ArrayList<>();

  public Player getHeroByName(String name) {
    for (Player player : listOfHeroes) {
      if (player.getName().equals(name)) {
        return player;
      }
    }
    return null;
  }

  public void addPlayerToGuild(Player player) {
    listOfHeroes.add(player);
  }
}
