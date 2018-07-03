package com.example.battosai.tesaplikasi001.Object;

/**
 * Created by Battosai on 3/27/2017.
 */

public class Event {

    int id;
    String namaevent,lokasi,desk,tgl_event,gambar;// alt + Insert + Getter and Setter
    double lat,lng;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaevent() {
        return namaevent;
    }

    public void setNamaevent(String namaevent) {
        this.namaevent = namaevent;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getTgl_event() {
        return tgl_event;
    }

    public void setTgl_event(String tgl_event) {
        this.tgl_event = tgl_event;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
