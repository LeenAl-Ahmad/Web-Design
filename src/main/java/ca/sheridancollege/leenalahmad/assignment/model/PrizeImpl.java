package ca.sheridancollege.leenalahmad.assignment.model;

public class PrizeImpl implements Prize {
    private String description;
    private String imgPath;

    public PrizeImpl(String description, String imgPath) {
        this.description = description;
        this.imgPath = imgPath;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getImgPath() {
        return imgPath;
    }
}
