package pl.rpg.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorldOfFloatingIslands {
    List<Location> listOfFloatingIslands = new ArrayList<>();

    public Location summonTheFloatingIslandByName(String name){
        for (Location location: listOfFloatingIslands) {
            if(location.getName().equals(name)){
                return location;
            }
        }
        return null;
    }
    public void addLocation(Location location){
        listOfFloatingIslands.add(location);
    }
}
