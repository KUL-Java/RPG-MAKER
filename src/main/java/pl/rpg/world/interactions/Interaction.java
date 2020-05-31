package pl.rpg.world.interactions;

import pl.rpg.world.PointOfInterest;

@FunctionalInterface
public interface Interaction {
  void interact(PointOfInterest pointOfInterest);}
