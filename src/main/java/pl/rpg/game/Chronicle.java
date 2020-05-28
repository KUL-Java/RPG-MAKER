package pl.rpg.game;

import lombok.Data;

import java.util.LinkedList;
import java.util.ListIterator;

@Data
public class Chronicle {
    public final String name;
    private LinkedList<Page> pages = new LinkedList<>();


    public Page turnPage(){
        ListIterator listIterator = pages.listIterator();
        return (Page) listIterator.next();
    }
}
