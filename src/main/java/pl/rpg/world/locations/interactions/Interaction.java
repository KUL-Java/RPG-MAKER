package pl.rpg.world.locations.interactions;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.rpg.world.locations.PointOfInterest;

@FunctionalInterface
@JsonDeserialize(as = Command.class)
public interface Interaction {
  void interact(PointOfInterest pointOfInterest);}
