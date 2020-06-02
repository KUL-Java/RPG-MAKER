package pl.rpg.storyteller.minions.chornicles;

import lombok.*;


import java.util.LinkedList;
import java.util.ListIterator;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Chronicle {
  private String name;
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
      return null;
    }
    return listIterator.next();
  }

  public String getName() {
    return name;
  }

  public LinkedList<Page> getPages() {
    return pages;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPages(LinkedList<Page> pages) {
    this.pages = pages;
  }

  public void addPage(Page page) {
    pages.add(page);
  }
}
