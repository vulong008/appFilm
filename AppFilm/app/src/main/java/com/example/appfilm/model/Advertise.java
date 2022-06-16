package com.example.appfilm.model;

public class Advertise {
    private int id;
    private String imageAds;

    public Advertise(int idAds, String imgAds) {
        this.id = idAds;
        this.imageAds = imgAds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageAds() {
        return imageAds;
    }

    public void setImageAds(String imageAds) {
        this.imageAds = imageAds;
    }

    @Override
    public String toString() {
        return "Advertise{" +
                "id=" + id +
                ", imageAds='" + imageAds + '\'' +
                '}';
    }
}
