package ca.sheridancollege.leenalahmad.assignment.controller;

import ca.sheridancollege.leenalahmad.assignment.model.GameModel;
import ca.sheridancollege.leenalahmad.assignment.model.Box;
import ca.sheridancollege.leenalahmad.assignment.model.Prize;
import ca.sheridancollege.leenalahmad.assignment.model.GameBox;
import ca.sheridancollege.leenalahmad.assignment.model.PrizeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class GameController implements GameModel {

    private List<Box> boxes = new ArrayList<>();
    private Random random = new Random();

    @GetMapping("/play")
    public String play(Model model) {
        initializeBoxes();  // Reset the boxes with random prizes
        model.addAttribute("boxes", getAllPrizes());  // Add all prize descriptions to the model
        return "play";  // Return the play.html page
    }

    @PostMapping("/result")
    public String result(@RequestParam int selectedBox, Model model) {
        String selectedPrize = getPrize(selectedBox);  // Get the prize for the selected box
        model.addAttribute("selectedPrize", selectedPrize);  // Pass the selected prize to the result page
        model.addAttribute("allPrizes", getAllPrizes());  // Pass all prize descriptions
        return "result";  // Return the result.html page
    }

    @Override
    public void initializeBoxes() {
        boxes.clear();  // Clear the boxes before initializing
        for (int i = 0; i < 3; i++) {
            boxes.add(createBoxWithPrize());  // Add a box with a random prize
        }
    }

    @Override
    public List<String> getAllPrizes() {
        List<String> prizes = new ArrayList<>();
        for (Box box : boxes) {
            prizes.add(box.getPrize().getDescription());  // Get the description of each prize
        }
        return prizes;
    }

    @Override
    public String getPrize(int index) {
        return boxes.get(index).getPrize().getDescription();  // Get the prize of the selected box
    }

    // Helper method to create a box with a random prize
    private Box createBoxWithPrize() {
        Box box = new GameBox();  // Create a new box
        Prize prize = randomPrize();  // Assign a random prize
        box.setPrize(prize);  // Set the prize for the box
        return box;
    }

    // Helper method to return a random prize
    private Prize randomPrize() {
        String[] prizes = {"Candy", "iPhone", "100$", "TV", "PS5", "Trip to Hawaii"};
        int index = random.nextInt(prizes.length);  // Pick a random prize
        return new PrizeImpl(prizes[index]);  // Return a prize with the chosen description
    }
}
