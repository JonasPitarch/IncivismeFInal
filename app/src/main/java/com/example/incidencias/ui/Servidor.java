package com.example.incidencias.ui;

public class Servidor {
    String latitud;
    String longitud;
    String direccio;
    String dserver;

    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getDserver() {
        return dserver;
    }

    public void setDserver(String dserver) {
        this.dserver = dserver;
    }

    public Servidor(String latitud, String longitud, String direccio, String dserver, String url) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccio = direccio;
        this.dserver = dserver;
        this.url = url;
    }

    public Servidor() {
    }
}