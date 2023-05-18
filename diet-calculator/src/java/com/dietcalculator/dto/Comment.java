package com.dietcalculator.dto;

/**
 *
 * @author admin
 */
public class Comment {
    private String commentID;
    private String userID;
    private String productID;
    private double rate;
    private String content;

    public Comment() {
    }

    public Comment(String commentID, String userID, String productID, double rate, String content) {
        this.commentID = commentID;
        this.userID = userID;
        this.productID = productID;
        this.rate = rate;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentID=" + commentID + ", userID=" + userID + ", productID=" + productID + ", rate=" + rate + ", content=" + content + '}';
    }
    
}
