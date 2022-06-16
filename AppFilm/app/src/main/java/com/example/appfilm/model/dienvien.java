package com.example.appfilm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class dienvien {
    @SerializedName("idDienVien")
    @Expose
    private int idDienVien;
    @SerializedName("tenDienVien")
    @Expose
    private String tenDienVien;
    @SerializedName("imageDienVien")
    @Expose
    public String imageDienVien;

    public dienvien() {
        this.idDienVien = idDienVien;
        this.tenDienVien = tenDienVien;
        this.imageDienVien = imageDienVien;
    }

    public int getIdDienVien() {
        return idDienVien;
    }

    public void setIdDienVien(int idDienVien) {
        this.idDienVien = idDienVien;
    }

    public String getTenDienVien() {
        return tenDienVien;
    }

    public void setTenDienVien(String tenDienVien) {
        this.tenDienVien = tenDienVien;
    }

    public String getImageDienVien() {
        return imageDienVien;
    }

    public void setImageDienVien(String imageDienVien) {
        this.imageDienVien = imageDienVien;
    }


}
