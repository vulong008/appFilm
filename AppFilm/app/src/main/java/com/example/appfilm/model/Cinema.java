package com.example.appfilm.model;

import com.google.gson.annotations.SerializedName;

public class Cinema {
    @SerializedName("idRap")
    private int idRap;

    @SerializedName("tenRap")
    private String tenRap;

    @SerializedName("diaChi")
    private String diaChi;

    public Cinema(int idRap, String tenRap, String diaChi) {
        this.idRap = idRap;
        this.tenRap = tenRap;
        this.diaChi = diaChi;
    }

    public int getIdRap() {
        return idRap;
    }

    public void setIdRap(int idRap) {
        this.idRap = idRap;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "idRap=" + idRap +
                ", tenRap='" + tenRap + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
