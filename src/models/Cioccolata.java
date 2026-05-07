package models;

public class Cioccolata implements Bevanda {

    private String descrizione = "Cioccolata";
    private float costo = 2.00f;

    @Override
    public String getDescrizione() {
        return this.descrizione;
    }

    @Override
    public float getCosto() {
        return this.costo;
    }
}
