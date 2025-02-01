

import java.util.List;

public interface GameModel {
    void shufflePrizes();
    List<String> getAllPrizes();
    String getPrize(int index);
}