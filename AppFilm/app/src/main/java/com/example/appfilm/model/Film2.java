package com.example.appfilm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Film2 {
    @SerializedName("idPhim")
    @Expose
    private int idPhim;

    @SerializedName("daoDien")
    @Expose
    private String daoDien;

    @SerializedName("hinhAnh")
    @Expose
    private String hinhAnh;

    @SerializedName("sum")
    @Expose
    private float sum;

    @SerializedName("tenTheloai")
    @Expose
    private String tenTheloai;

    @SerializedName("iconMac")
    @Expose
    private String iconMac;

    @SerializedName("ngayPhathanh")
    @Expose
    private String ngayPhathanh;

    @SerializedName("thoiLuong")
    @Expose
    private int thoiLuong;

    @SerializedName("video")
    @Expose
    private String video;

    @SerializedName("moTa")
    @Expose
    private String moTa;

    @SerializedName("tenPhim")
    @Expose
    private String tenPhim;

    @SerializedName("dienvien")
    @Expose
    private List<dienvien> dienvien = new ArrayList<>();

    @SerializedName("phimTL")
    @Expose
    private List<phimTheLoai> phimTL = new ArrayList<>();

    @Override
    public String toString() {
        return "Film2{" +
                "idPhim=" + idPhim +
                ", daoDien='" + daoDien + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", sum=" + sum +
                ", tenTheloai='" + tenTheloai + '\'' +
                ", iconMac='" + iconMac + '\'' +
                ", ngayPhathanh='" + ngayPhathanh + '\'' +
                ", thoiLuong=" + thoiLuong +
                ", video='" + video + '\'' +
                ", moTa='" + moTa + '\'' +
                ", tenPhim='" + tenPhim + '\'' +
                ", dienvien=" + dienvien +
                ", phimTL=" + phimTL +
                '}';
    }

    public class phimTheLoai{
        @SerializedName("hinhAnh")
        @Expose
        private String hinhAnh;

        public phimTheLoai(String hinhAnh) {
            this.hinhAnh = hinhAnh;
        }

        public String getHinhAnh() {
            return hinhAnh;
        }

        public void setHinhAnh(String hinhAnh) {
            this.hinhAnh = hinhAnh;
        }
    }

    public class dienvien{
       @SerializedName("idDienVien")
       @Expose
       private int idDienVien;
       @SerializedName("tenDienVien")
       @Expose
       private String tenDienVien;
       @SerializedName("imageDienVien")
       @Expose
       private String imageDienVien;

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

        @Override
        public String toString() {
            return "dienvien{" +
                    "idDienVien=" + idDienVien +
                    ", tenDienVien='" + tenDienVien + '\'' +
                    ", imageDienVien='" + imageDienVien + '\'' +
                    '}';
        }
    }

    public Film2(int id, String tenPhim, int thoiLuong, String daoDien, String moTa, String hinhAnh, String video, String ngayPhathanh, String iconMac, String tenTheloai, List<dienvien> dienvien) {
//        super();
        this.idPhim = id;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.daoDien = daoDien;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.video = video;
        this.ngayPhathanh = ngayPhathanh;
        this.iconMac = iconMac;
        this.tenTheloai = tenTheloai;
        this.dienvien = dienvien;
    }

    public int getId() {
        return idPhim;
    }

    public void setId(int id) {
        this.idPhim = id;
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
        video = video;
    }

    public String getNgayPhatHanh() {
        return ngayPhathanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhathanh = ngayPhathanh;
    }

    public String getMac() {
        return iconMac;
    }

    public void setMac(String mac) {
        this.iconMac = iconMac;
    }

    public String getTheloai() {
        return tenTheloai;
    }

    public void setTheloai(String theloai) {
        this.tenTheloai = theloai;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public List<dienvien> getDienvien() {
        return dienvien;
    }

    public void setDienvien(List<Film2.dienvien> dienvien) {
        this.dienvien = dienvien;
    }

    public List<phimTheLoai> getPhimTL() {
        return phimTL;
    }

    public void setPhimTL(List<phimTheLoai> phimTL) {
        this.phimTL = phimTL;
    }
}

