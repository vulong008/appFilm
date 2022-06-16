package com.example.appfilm.model;

import java.util.Date;

public class FilmNew {
    private int id;
    private String tenPhim;
    private int thoiLuong;
    private String daoDien;
    private String moTa;
    private String hinhAnh;
    private String video;
    private Date ngayPhathanh;
    private String theLoai;
    private String iconMac;

    public FilmNew(int id, String tenPhim, int thoiLuong, String daoDien, String moTa, String hinhAnh, String video, Date ngayPhathanh, String theLoai, String iconMac) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.daoDien = daoDien;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.video = video;
        this.ngayPhathanh = ngayPhathanh;
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

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Date getNgayPhathanh() {
        return ngayPhathanh;
    }

    public void setNgayPhathanh(Date ngayPhathanh) {
        this.ngayPhathanh = ngayPhathanh;
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
        return "FilmNew{" +
                "id=" + id +
                ", tenPhim='" + tenPhim + '\'' +
                ", thoiLuong=" + thoiLuong +
                ", daoDien='" + daoDien + '\'' +
                ", moTa='" + moTa + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", video='" + video + '\'' +
                ", ngayPhathanh=" + ngayPhathanh +
                ", theLoai='" + theLoai + '\'' +
                ", iconMac='" + iconMac + '\'' +
                '}';
    }
}
