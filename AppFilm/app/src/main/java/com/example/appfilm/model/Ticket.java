package com.example.appfilm.model;

public class Ticket {
    private int idVe,idLichChieu,tinhTrang,tongTien,giaMacDinh;
    private String idGhe,loaiGhe;


    @Override
    public String toString() {
        return "Ticket{" +
                "idVe=" + idVe +
                ", idLichChieu=" + idLichChieu +
                ", tinhTrang=" + tinhTrang +
                ", tongTien=" + tongTien +
                ", giaMacDinh=" + giaMacDinh +
                ", idGhe='" + idGhe + '\'' +
                ", loaiGhe='" + loaiGhe + '\'' +
                '}';
    }

    public int getGiaMacDinh() {
        return giaMacDinh;
    }

    public void setGiaMacDinh(int giaMacDinh) {
        this.giaMacDinh = giaMacDinh;
    }

    public String getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(String loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public Ticket(int idVe, int idLichChieu, int tinhTrang, int tongTien, String idGhe) {
        this.idVe = idVe;
        this.idLichChieu = idLichChieu;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
        this.idGhe = idGhe;
    }

    public Ticket(int idVe, int idLichChieu, int tinhTrang, int tongTien, int giaMacDinh, String idGhe, String loaiGhe) {
        this.idVe = idVe;
        this.idLichChieu = idLichChieu;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
        this.giaMacDinh = giaMacDinh;
        this.idGhe = idGhe;
        this.loaiGhe = loaiGhe;
    }

    public Ticket() {
    }

    public int getIdVe() {
        return idVe;
    }

    public void setIdVe(int idVe) {
        this.idVe = idVe;
    }

    public int getIdLichChieu() {
        return idLichChieu;
    }

    public void setIdLichChieu(int idLichChieu) {
        this.idLichChieu = idLichChieu;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getIdGhe() {
        return idGhe;
    }

    public void setIdGhe(String idGhe) {
        this.idGhe = idGhe;
    }

}
