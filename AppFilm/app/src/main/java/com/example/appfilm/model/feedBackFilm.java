package com.example.appfilm.model;

public class feedBackFilm {
    private String tenDangNhap;
    private float ratingFeedBack;
    private String commentFeedBack;

    public feedBackFilm(String tenDN,float ratingFeedBack, String commentFeedBack) {
        this.tenDangNhap = tenDN;
        this.ratingFeedBack = ratingFeedBack;
        this.commentFeedBack = commentFeedBack;
    }

    public String getTenDN() {
        return tenDangNhap;
    }

    public void setTenDN(String tenDN) {
        this.tenDangNhap = tenDN;
    }

    public float getRatingFeedBack() {
        return ratingFeedBack;
    }

    public void setRatingFeedBack(float ratingFeedBack) {
        this.ratingFeedBack = ratingFeedBack;
    }

    public String getCommentFeedBack() {
        return commentFeedBack;
    }

    public void setCommentFeedBack(String commentFeedBack) {
        this.commentFeedBack = commentFeedBack;
    }
}
