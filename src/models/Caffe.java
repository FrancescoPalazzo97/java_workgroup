package models;

/**
 * Rapresenta la bevanda Caffè con proprio stato e operazioni basiche per
 * recuperare quest'ultimo
 */
public class Caffe implements Bevanda {
    private String descrizione = "Caffè";
    private float costo = 1.20f;

    @Override
    public String getDescrizione() {
        return this.descrizione;
    }

    @Override
    public float getCosto() {
        return this.costo;
    }

}
