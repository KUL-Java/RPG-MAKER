package pl.rpg.storyteller.minions.imps;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.rpg.game.Chronicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryImp {
    //TODO implement reading Chronicles from file.
    //TODO read at least 2 pages as storyTeller in mein method.
   /* public static List<Chronicle> getChroniclesFromFile(String filename){

    }*/
    public static Chronicle getChroniclesFromJson(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Chronicle chronicle = objectMapper.readValue(new File("chronicles.json"),Chronicle.class);
        return chronicle;
    }
    public void writeToJsonFile(Chronicle chronicle) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("chronicles.json"),chronicle);
    }
}
