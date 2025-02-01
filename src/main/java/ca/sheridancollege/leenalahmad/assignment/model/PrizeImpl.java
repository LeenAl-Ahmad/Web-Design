package ca.sheridancollege.leenalahmad.assignment.model;

public class PrizeImpl implements Prize {
    private String description;

    public PrizeImpl(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
