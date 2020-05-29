package pl.rpg.storyteller.minions.imps;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.rpg.game.Player;

import java.io.File;
import java.io.IOException;

public class PlayerImp {
  public static Player getChroniclesFromJson(String filename) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new File("players.json"), Player.class);
  }

  public void writeToJsonFile(Player player) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writeValue(new File("players.json"), player);
  }
}
