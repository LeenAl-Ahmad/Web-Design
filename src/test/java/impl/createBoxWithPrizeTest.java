package impl;

import ca.sheridancollege.leenalahmad.assignment.controller.GameController;
import ca.sheridancollege.leenalahmad.assignment.model.Box;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = new GameController(); // Initialize before each test
    }

    @Test
    void testCreateBoxWithPrize() {
        Box box = gameController.createBoxWithPrize(); // Generate a box with a random prize

        assertNotNull(box, "Box should not be null");
        assertNotNull(box.getPrize(), "Box should contain a prize");
        assertNotNull(box.getPrize().getDescription(), "Prize description should not be null");
        assertNotNull(box.getPrize().getImgPath(), "Prize image path should not be null");
    }
}
