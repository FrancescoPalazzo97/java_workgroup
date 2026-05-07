package models;

public class Te implements Bevanda {

    private String descrizione = "Te";
    private float costo = 1.00f;

    @Override
    public String getDescrizione() {
        return this.descrizione;
    }

    @Override
    public float getCosto() {
        return this.costo;
    }

}
