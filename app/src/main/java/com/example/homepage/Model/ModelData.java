package com.example.homepage.Model;

public class ModelData {

    private int gambar;
    private String titel;

    public ModelData(int gambar, String titel) {
        this.gambar = gambar;
        this.titel = titel;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Override
    public String toString() {
        return "ModelData{" +
                "gambar=" + gambar +
                ", titel='" + titel + '\'' +
                '}';
    }
}
