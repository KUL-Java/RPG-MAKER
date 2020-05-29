package pl.rpg.game;


import pl.rpg.storyteller.StoryTeller;
import pl.rpg.storyteller.StoryWhisperer;
import pl.rpg.storyteller.StoryYeller;
import pl.rpg.storyteller.minions.ChronicleKeeperMinion;
import pl.rpg.storyteller.minions.PathFindingMinion;
import pl.rpg.storyteller.minions.imps.LibraryImp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
     StoryTeller storyTeller = new StoryWhisperer();
     StoryTeller storyYeller = new StoryYeller();


     PathFindingMinion pathFindingMinion = PathFindingMinion.callMinion();
     Location location = new Location("Bretonia","Bretonia, dużo koni i pojebanych rycerzy",1);
     Location location1 = new Location("Imperium","Troche parowozow, wszyscy wielbia jakis mlotek",1);
     Player player = new Player("Andrzej","Andrzej wielki jak domp",1000,location);
     LinkedLocation linkedLocation = new LinkedLocation("N",location1);
     location.addLocation(linkedLocation);

     if(pathFindingMinion.studyAncientMaps(location,"W") != null){
         player.setCurrentLocation(pathFindingMinion.studyAncientMaps(location,"W"));
         System.out.println(player.getCurrentLocation());
     }else {
      System.out.println("Impossibru");
     }



     Library library = new Library();
     library.addChronicle(LibraryImp.getChroniclesFromJson("chronicles.json"));
     ChronicleKeeperMinion chronicleKeeperMinion = ChronicleKeeperMinion.callMinion();
     chronicleKeeperMinion.giveMinionKeyToLibrary(library);
     Chronicle chronicle = chronicleKeeperMinion.bringChronicleByItsName("Het onderwijs in Nederland");
     storyTeller.readFromChronicle(chronicle);
     storyTeller.readFromChronicle(chronicle);
     storyTeller.readFromChronicle(chronicle);
    }
}
