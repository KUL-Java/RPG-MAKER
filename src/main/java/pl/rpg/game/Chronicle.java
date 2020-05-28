package pl.rpg.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.ListIterator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Chronicle {
  public String name;
  private LinkedList<Page> pages = new LinkedList<>();
  private ListIterator listIterator = pages.listIterator();

  Chronicle(String name) {
    this.name = name;
  }

  public Page turnPage() {
    System.out.println(pages);
    if (!listIterator.hasNext()) {
      return new Page("The end");
    }
    return (Page) listIterator.next();
  }

}
