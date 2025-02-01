package ca.sheridancollege.leenalahmad.assignment.model;

public class GameBox implements Box {
    private Prize prize;

    @Override
    public Prize getPrize() {
        return prize;
    }

    @Override
    public void setPrize(Prize prize) {
        this.prize = prize;
    }
}
