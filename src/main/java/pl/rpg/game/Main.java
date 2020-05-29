package pl.rpg.game;


import pl.rpg.storyteller.StoryTeller;
import pl.rpg.storyteller.StoryWhisperer;
import pl.rpg.storyteller.StoryYeller;
import pl.rpg.storyteller.minions.ChronicleKeeperMinion;
import pl.rpg.storyteller.minions.imps.LibraryImp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
     StoryTeller storyTeller = new StoryWhisperer();
     StoryTeller storyYeller = new StoryYeller();
     Library library = new Library();
     library.addChronicle(LibraryImp.getChroniclesFromJson("chronicles.json"));
     ChronicleKeeperMinion chronicleKeeperMinion = ChronicleKeeperMinion.callMinion();
     chronicleKeeperMinion.giveMinionKeyToLibrary(library);
     Chronicle chronicle = chronicleKeeperMinion.bringChronicleByItsName("Het onderwijs in Nederland");
     storyYeller.readFromChronicle(chronicle);
     storyYeller.readFromChronicle(chronicle);
     storyYeller.readFromChronicle(chronicle);
    }
}
