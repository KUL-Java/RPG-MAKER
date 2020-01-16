package pl.rpg.game;

public class Way {
    private String text;
    private int followingHistoryID;

    public Way(String text, int followingHistoryID) {
        this.text = text;
        this.followingHistoryID = followingHistoryID;
    }

    public String getText() {
        return text;
    }

    public int getFollowingHistoryID() {
        return followingHistoryID;
    }

}
