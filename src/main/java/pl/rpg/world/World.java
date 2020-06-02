package pl.rpg.world;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.rpg.game.Chronicle;
import pl.rpg.game.Library;
import pl.rpg.game.Page;
import pl.rpg.game.Player;
import pl.rpg.storyteller.StoryTeller;
import pl.rpg.storyteller.minions.*;
import pl.rpg.storyteller.minions.fiends.LibraryFiend;
import pl.rpg.world.interactions.Command;

import java.util.ArrayList;

import java.util.List;

@Getter
@NoArgsConstructor
public class World {
  MindReaderMinion mindReaderMinion = MindReaderMinion.callMinion();
  MotionMinion motionMinion = MotionMinion.callMinion();
  GateKeeperMinion gateKeeperMinion = GateKeeperMinion.callMinion();
  HeraldMinion heraldMinion = HeraldMinion.callMinion();
  PathFindingMinion pathFindingMinion = PathFindingMinion.callMinion();
  ChronicleKeeperMinion chronicleKeeperMinion = ChronicleKeeperMinion.callMinion();
  ThoughtDestinyMinion thoughtDestinyMinion = ThoughtDestinyMinion.callMinion();
  CuriousMinion curiousMinion = CuriousMinion.callMinion();

  StoryTeller storyTeller;
  LibraryFiend libraryFiend;
  Library library;
  Page page;
  List<Location> locations = new ArrayList<>();

  public World(StoryTeller storyTeller, LibraryFiend libraryFiend, Library library) {
    this.storyTeller = storyTeller;
    this.libraryFiend = libraryFiend;
    this.library = library;
  }

  public void play(Player player) {
    while (true) {
      motionMinion.assignPlayer(player);
      heraldMinion.announce(String.format("--%s--", player.getCurrentLocation().getName()));
      heraldMinion.announce(player.getCurrentLocation().getDescription());
      heraldMinion.announce(String.valueOf(player.getCurrentLocation().getExits()));
      String playerWill = mindReaderMinion.getPlayerWill();
      if (gateKeeperMinion.isExit(playerWill)) {
        final Exits desiredDirection = thoughtDestinyMinion.interpretThoughtAsExit(playerWill);
        try {
          motionMinion.moveAssignedPlayer(
              pathFindingMinion.studyAncientMaps(player.getCurrentLocation(), desiredDirection));
        } catch (NullPointerException e) {
          heraldMinion.announce(desiredDirection.getOptionName());
        }
      } else {
        curiousMinion.assignLocation(player.getCurrentLocation());
        System.out.println(curiousMinion.interact(playerWill));
      }
      if (playerWill.equals("End this game")) {
        break;
      }
    }
  }

  public void addLocation(Location location) {
    this.locations.add(location);
  }

  public void teleportLocations(List<Location> locations) {
    this.locations.addAll(locations);
  }

  public void addPointOfInterest(Location location, PointOfInterest pointOfInterest) {
    location.addPointsOfInterest(pointOfInterest);
  }

  public void addInteraction(PointOfInterest pointOfInterest, Command command) {
    pointOfInterest.addCommand(command);
  }

  public Location getLocationByName(String name) {
    for (Location location : locations) {
      if (location.getName().equals(name)) {
        return location;
      }
    }
    return null;
  }

  public void readStory(Chronicle chronicle) {
    storyTeller.readFromChronicle(chronicle);
  }
}
