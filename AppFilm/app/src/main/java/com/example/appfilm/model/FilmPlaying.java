package com.example.appfilm.model;

public class FilmPlaying {
    private int id;
    private String tenPhim;
    private int thoiLuong;
    private String hinhAnh;
    private String theLoai;
    private String iconMac;

    public FilmPlaying(int id, String tenPhim, int thoiLuong, String hinhAnh, String theLoai, String iconMac) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.hinhAnh = hinhAnh;
        this.theLoai = theLoai;
        this.iconMac = iconMac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getIconMac() {
        return iconMac;
    }

    public void setIconMac(String iconMac) {
        this.iconMac = iconMac;
    }

    @Override
    public String toString() {
        return "FilmPlaying{" +
                "id=" + id +
                ", tenPhim='" + tenPhim + '\'' +
                ", thoiLuong=" + thoiLuong +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", iconMac='" + iconMac + '\'' +
                '}';
    }
}
