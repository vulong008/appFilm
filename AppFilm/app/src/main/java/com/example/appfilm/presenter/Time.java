package com.example.appfilm.presenter;

public class Time {
    private int idKhunggio;
    private String time;

    public Time(int idKhunggio, String time) {
        this.idKhunggio = idKhunggio;
        this.time = time;
    }

    public int getIdKhunggio() {
        return idKhunggio;
    }

    public void setIdKhunggio(int idKhunggio) {
        this.idKhunggio = idKhunggio;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Time{" +
                "idKhunggio=" + idKhunggio +
                ", time='" + time + '\'' +
                '}';
    }
}
