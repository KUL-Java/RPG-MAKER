package pl.rpg.game;

import java.util.Objects;

public class Game {

  private HistoryRepository historyRepository;
  private UserReader userReader;
  private UserWriter userWriter;

  public Game(HistoryRepository historyRepository, UserReader userReader, UserWriter userWriter) {
    this.historyRepository = historyRepository;
    this.userReader = userReader;
    this.userWriter = userWriter;
  }

  public void runGame() {
    History firstHistory = historyRepository.getFirstHistory();
    userWriter.writeHistory(firstHistory);
    while (true) { // infinite loop
      char choice = userReader.fetchChoice();
      if (firstHistory.getWays().get(choice).getFollowingHistoryID()!=-1) {
        History nextHistory =
            historyRepository.fetchHistory(
                firstHistory.getWays().get(choice).getFollowingHistoryID());
        userWriter.writeHistory(nextHistory);
      } else {
        return;
      }
    }
  }
}
