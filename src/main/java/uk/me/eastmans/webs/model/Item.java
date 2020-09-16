package uk.me.eastmans.webs.model;

//This class represents a Item that is being offered
public class Item {

    private String title;

    private String description;

    private Integer buyNowPrice;

    private String imagePath;

    public Item(String title, String description, Integer buyNowPrice, String imagePath) {
        this.title = title;
        this.description = description;
        this.buyNowPrice = buyNowPrice;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Integer getBuyNowPrice() {
        return buyNowPrice;
    }

}