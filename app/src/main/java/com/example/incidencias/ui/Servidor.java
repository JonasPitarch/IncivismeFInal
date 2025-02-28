package com.example.incidencias.ui;

public class Servidor {
    String latitud;
    String longitud;
    String direccio;
    String dserver;

    String hola = "hola carles";

    String url;

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

    public String getHola() {
        return hola;
    }

    public void setHola(String hola) {
        this.hola = hola;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Servidor(String latitud, String longitud, String direccio, String dserver, String hola, String url) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccio = direccio;
        this.dserver = dserver;
        this.hola = hola;
        this.url = url;
    }

    public Servidor() {
    }
}