package pl.rpg.storyteller.minions.fiends;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.rpg.world.Location;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SetUpFiend {
    public static Location[] getLocationsFromJson(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("locations.json"), Location[].class);
    }

    public void writeToJsonFile(List<Location> locations) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("locations.json"), locations);
    }


}
