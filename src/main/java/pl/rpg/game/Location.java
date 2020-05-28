package pl.rpg.game;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
  private long id;
  private String name;
  private String description;
  private Set<LinkedLocation> linkedLocations;

  @Setter
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  public class LinkedLocation {
    Exits exits;
    Location linkedLocation;
  }
}
