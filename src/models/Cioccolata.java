package models;

/**
 * Rapresenta la bevanda Cioccolata con proprio stato e operazioni basiche per
 * recuperare quest'ultimo
 */
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
