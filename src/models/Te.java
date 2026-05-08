package models;

/**
 * Rapresenta la bevanda Te con proprio stato e operazioni basiche per
 * recuperare quest'ultimo
 */
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
