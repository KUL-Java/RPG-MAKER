package pl.rpg.world;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class World {
    String name;
    List<Location> locations = new ArrayList<>();

    public World(String name){
        this.name = name;
    }
    public void addLocations(Location[] locations){
        this.locations.addAll(Arrays.asList(locations));
    }
}
