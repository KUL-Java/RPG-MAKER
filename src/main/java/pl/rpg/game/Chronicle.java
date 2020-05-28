package pl.rpg.game;

import lombok.*;

import java.util.LinkedList;
import java.util.ListIterator;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Chronicle {
    public String name;
    private LinkedList<Page> pages = new LinkedList<>();
    private ListIterator<Page> listIterator;

    Chronicle(String name) {
        this.name = name;
    }

    public Page turnPage() {
        if (listIterator == null) {
            listIterator = pages.listIterator();
        }
        if (!listIterator.hasNext()) {
            return new Page("The end");
        }
        return listIterator.next();
    }
}
