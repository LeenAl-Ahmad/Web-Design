package impl;

import ca.sheridancollege.leenalahmad.assignment.controller.GameController;
import ca.sheridancollege.leenalahmad.assignment.model.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerRandomPrizeTest {

    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = new GameController(); // Initialize before each test
    }

    @Test
    void testRandomPrizeSelection() {
        Set<String> uniquePrizes = new HashSet<>();

        // Run randomPrize() multiple times to check variability
        for (int i = 0; i < 50; i++) {
            Prize prize = gameController.randomPrize();
            assertNotNull(prize, "Prize should not be null");
            assertNotNull(prize.getDescription(), "Prize description should not be null");
            assertNotNull(prize.getImgPath(), "Prize image path should not be null");

            uniquePrizes.add(prize.getDescription());
        }

        // Ensure at least 3 different prizes were selected, proving randomness
        assertTrue(uniquePrizes.size() >= 3, "Random prize selection should be varied");
    }
}
