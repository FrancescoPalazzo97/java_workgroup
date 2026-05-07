package models;

public abstract class Bevanda {
    private String descrizione;
    private float costo;

    public Bevanda(String descrizione, float costo) {
        this.descrizione = descrizione;
        this.costo = costo;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public float getCosto() {
        return this.costo;
    }
}
