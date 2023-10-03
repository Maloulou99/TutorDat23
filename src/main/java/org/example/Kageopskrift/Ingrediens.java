package org.example.Kageopskrift;

public class Ingrediens {

    private String type;
    private double mængde;
    private String enhed;
    private double energiPerEnhed;

    public Ingrediens(String type, double mængde, String enhed, double energiPerEnhed) {
        this.type = type;
        this.mængde = mængde;
        this.enhed = enhed;
        this.energiPerEnhed = energiPerEnhed;
    }

    public String getType() {
        return type;
    }

    public double getMængde() {
        return mængde;
    }

    public String getEnhed() {
        return enhed;
    }

    public double getEnergiPerEnhed() {
        return energiPerEnhed;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMængde(double mængde) {
        this.mængde = mængde;
    }

    public void setEnhed(String enhed) {
        this.enhed = enhed;
    }

    public void setEnergiPerEnhed(double energiPerEnhed) {
        this.energiPerEnhed = energiPerEnhed;
    }
}
