package pl.rpg.storyteller.minions.fiends;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.rpg.storyteller.minions.chornicles.Chronicle;

import java.io.File;
import java.io.IOException;

public class LibraryFiend {

  public static Chronicle getChroniclesFromJson() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new File("chronicles.json"), Chronicle.class);
  }

  public void writeToJsonFile(Chronicle chronicle) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writeValue(new File("chronicles.json"), chronicle);
  }
}
