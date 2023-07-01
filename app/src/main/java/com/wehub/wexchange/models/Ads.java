package com.wehub.wexchange.models;

import java.io.Serializable;

public class Ads  implements Serializable {
    String image;
    String title;
    String price;
    String description;
    String ownerName;

    public Ads(String image, String title, String price, String description, String ownerName) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.description = description;
        this.ownerName = ownerName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
