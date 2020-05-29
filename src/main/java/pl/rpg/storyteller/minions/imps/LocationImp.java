package pl.rpg.storyteller.minions.imps;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.rpg.game.Location;

import java.io.File;
import java.io.IOException;

public class LocationImp {

  public static Location getChroniclesFromJson(String filename) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new File("locations.json"), Location.class);
  }

  public void writeToJsonFile(Location location) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writeValue(new File("locations.json"), location);
  }
}
