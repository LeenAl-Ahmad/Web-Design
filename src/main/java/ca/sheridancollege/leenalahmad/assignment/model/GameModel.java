package ca.sheridancollege.leenalahmad.assignment.model;

import java.util.List;

public interface GameModel {
    void initializeBoxes();
    List<String> getAllPrizes();
    Prize getPrize(int index);
}
