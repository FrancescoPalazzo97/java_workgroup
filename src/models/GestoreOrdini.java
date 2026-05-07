package models;

import java.util.ArrayList;
import java.util.List;

public class GestoreOrdini {
    private static GestoreOrdini instance;
    private Bevanda bevandaCorrente;
    private List<String> storicoOrdini;

    private GestoreOrdini() {
        storicoOrdini = new ArrayList<>();
    }

    public static GestoreOrdini getinstance() {
        if (instance == null) {
            instance = new GestoreOrdini();
        }
        return instance;
    }

    public void creaNuovaBevanda(Bevanda bevanda) {
        this.bevandaCorrente = bevanda;
    }

    public void aggiornaBevandaCorrente(Bevanda bevanda) {
        this.bevandaCorrente = bevanda;
    }

    public Bevanda getBevandaCorrente() {
        return bevandaCorrente;
    }

    public void confermaOrdine() {
        String riepilogo = bevandaCorrente.getDescrizione()
                + " - Totale: "
                + bevandaCorrente.getCosto();

        storicoOrdini.add(riepilogo);
        bevandaCorrente = null;
    }

}
