package com.dietcalculator.dto;

/**
 *
 * @author ADMIN
 */
public class Image {
    private String imageID;
    private String productID;
    private String mealID;
    private String commentID;
    private String url;

    public Image() {
    }

    public Image(String imageID, String productID, String mealID, String commentID, String url) {
        this.imageID = imageID;
        this.productID = productID;
        this.mealID = mealID;
        this.commentID = commentID;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getMealID() {
        return mealID;
    }

    public void setMealID(String mealID) {
        this.mealID = mealID;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    @Override
    public String toString() {
        return "Image{" + "imageID=" + imageID + ", productID=" + productID + ", mealID=" + mealID + ", commentID=" + commentID + ", url=" + url + '}';
    }
    
}
