package pl.rpg.storyteller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.rpg.game.*;
import pl.rpg.storyteller.minions.ChronicleKeeperMinion;
import pl.rpg.storyteller.minions.fiends.LibraryFiend;

import java.io.IOException;


class StoryTellerTest {

    StoryTeller storyTeller = new StoryYeller();
    ChronicleKeeperMinion chronicleKeeperMinion = ChronicleKeeperMinion.callMinion();
    @BeforeAll
    public static void setUp() throws IOException {

    }

    @SneakyThrows
    @Test
    public void shouldReadFromBook(){

        Library library = new Library();
        library.addChronicle(LibraryFiend.getChroniclesFromJson("chronicles.json"));
        chronicleKeeperMinion.giveMinionKeyToLibrary(library);
        Chronicle chronicle = chronicleKeeperMinion.bringChronicleByItsName("Het onderwijs in Nederland");
        storyTeller.readFromChronicle(chronicle);


    }


}