package pl.rpg.menu;

public enum Option {
  NEW_GAME(0, "New Game"),
  SETTINGS(1, "Settings"),
  EXIT(2, "Exit");

  int option;
  String description;

  Option(int option, String description) {
    this.option = option;
    this.description = description;
  }

  public static Option createFromInt(int option) {
    return values()[option];
  }

  @Override
  public String toString() {
    return option + " - " + description;
  }

  public static void printOptions() {
    Option[] values = Option.values();
    for (Option value : values) {
      System.out.println(value);
    }
  }
}
