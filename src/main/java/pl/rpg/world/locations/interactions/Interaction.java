package pl.rpg.world.locations.interactions;

import pl.rpg.world.locations.poi.PointOfInterest;

@FunctionalInterface
public interface Interaction {
  void interact(PointOfInterest pointOfInterest);}
