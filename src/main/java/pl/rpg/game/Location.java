package pl.rpg.game;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {
  private long id;
  private String name;
  private String description;
  private List<LinkedLocation> linkedLocations = new LinkedList<>();

  public Location(String name, String description,long id){
    this.name = name;
    this.description = description;
    this.id = id;
  }
  public void addLocation(LinkedLocation linkedLocation){
    linkedLocations.add(linkedLocation);
  }
}
