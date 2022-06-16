package com.example.appfilm.model;

public class PreTicket {
    String ngayChieu;
    String tenRap;
    String khungGio;
    String idPhong;

    public PreTicket() {
    }

    public PreTicket(String ngayChieu, String tenRap, String khungGio, String idPhong) {
        this.ngayChieu = ngayChieu;
        this.tenRap = tenRap;
        this.khungGio = khungGio;
        this.idPhong = idPhong;
    }



    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public String getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(String idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getKhungGio() {
        return khungGio;
    }

    public void setKhungGio(String khungGio) {
        this.khungGio = khungGio;
    }
}
