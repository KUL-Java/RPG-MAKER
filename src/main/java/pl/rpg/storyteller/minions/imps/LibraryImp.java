package pl.rpg.storyteller.minions.imps;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.rpg.game.Chronicle;

import java.io.File;
import java.io.IOException;

public class LibraryImp {

  public static Chronicle getChroniclesFromJson(String filename) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new File("chronicles.json"), Chronicle.class);
  }

  public void writeToJsonFile(Chronicle chronicle) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writeValue(new File("chronicles.json"), chronicle);
  }
}
