package pl.rpg.world.interactions;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.rpg.world.PointOfInterest;

@FunctionalInterface
@JsonDeserialize(as = Command.class)
public interface Interaction {
  void interact(PointOfInterest pointOfInterest);}
