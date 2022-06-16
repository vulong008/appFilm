package com.example.appfilm.model;

import java.util.List;

public class Film {
    private int id;
    private String tenPhim;
    private int thoiLuong;
    private String daoDien;
    private String moTa;
    private String hinhAnh;
    private String video;
    private String ngayPhathanh;
    private String theLoai;
    private List<dienvien> dienvienList;
    private String mac;
    private float sum;

    public Film(int id, String tenPhim, int thoiLuong, String daoDien, String moTa, String hinhAnh, String video, String ngayPhathanh, String theLoai, List<dienvien> dienvienList, String mac, float sum) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.daoDien = daoDien;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.video = video;
        this.ngayPhathanh = ngayPhathanh;
        this.theLoai = theLoai;
        this.dienvienList = dienvienList;
        this.mac = mac;
        this.sum = sum;
    }

    public Film(int id, String tenPhim, int thoiLuong, String hinhAnh, String theLoai, String mac) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.hinhAnh = hinhAnh;
        this.theLoai = theLoai;
        this.mac = mac;
    }

    public Film(int id, String tenPhim, int thoiLuong, String daoDien, String moTa, String hinhAnh, String video, String ngayPhathanh, String theLoai, String mac) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.daoDien = daoDien;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.video = video;
        this.ngayPhathanh = ngayPhathanh;
        this.theLoai = theLoai;
        this.mac = mac;
    }

    public String getNgayPhathanh() {
        return ngayPhathanh;
    }

    public void setNgayPhathanh(String ngayPhathanh) {
        this.ngayPhathanh = ngayPhathanh;
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

    public String getTheloai() {
        return theLoai;
    }

    public void setIdTheloai(String idTheloai) {
        this.theLoai = idTheloai;
    }

    public String getMac() {
        return mac;
    }

    public void setIdMac(String idMac) {
        this.mac = idMac;
    }

    public List<dienvien> getDienvienList() {
        return dienvienList;
    }

    public void setDienvienList(List<dienvien> dienvienList) {
        this.dienvienList = dienvienList;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", tenPhim='" + tenPhim + '\'' +
                ", thoiLuong=" + thoiLuong +
                ", daoDien='" + daoDien + '\'' +
                ", moTa='" + moTa + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", video='" + video + '\'' +
                ", ngayPhathanh='" + ngayPhathanh + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", dienvienList=" + dienvienList +
                ", mac='" + mac + '\'' +
                ", sum=" + sum +
                '}';
    }
}
