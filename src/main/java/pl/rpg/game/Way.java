package pl.rpg.game;

public class Way {
    private String text;
    private History followingHistory;

    public Way(String text, History followingHistory) {
        this.text = text;
        this.followingHistory = followingHistory;
    }

    public String getText() {
        return text;
    }

    public History getFollowingHistory() {
        return followingHistory;
    }

}
