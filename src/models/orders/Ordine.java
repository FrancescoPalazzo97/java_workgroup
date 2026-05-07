package models.orders;

import java.util.ArrayList;
import java.util.List;

import models.Bevanda;

public class Ordine {
    private int numeroOrdine;
    private List<Bevanda> bevande;
    private boolean confermato;

    public Ordine(int numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
        this.bevande = new ArrayList<>();
        this.confermato = false;
    }

    public int getNumeroOrdine() {
        return this.numeroOrdine;
    }

    public List<Bevanda> getBevande() {
        return this.bevande;
    }

    public boolean isConfermato() {
        return confermato;
    }

    public void aggiungiBevanda(Bevanda bevanda) {
        bevande.add(bevanda);
    }

    public void conferma() {
        if (bevande.isEmpty()) {
            return;
        }
        confermato = true;
    }

    public float getTotaleOrdine() {
        float totale = 0;

        for (Bevanda bevanda : bevande) {
            totale += bevanda.getCosto();
        }

        return totale;
    }

    public String getRiepilogoOrdine() {
        String riepilogo;

        riepilogo = "Ordine #" + numeroOrdine + "\n";

        for (int i = 0; i < bevande.size(); i++) {
            Bevanda bevanda = bevande.get(i);

            riepilogo += (i + 1) + " - " + bevanda.getDescrizione() + " - "
                    + String.format("EURO %.2f", bevanda.getCosto()) + "\n";
        }

        riepilogo += "Totale: " + String.format("EURO %.2f", getTotaleOrdine());

        return riepilogo;
    }

    @Override
    public String toString() {
        return "{" +
                " numeroOrdine='" + getNumeroOrdine() + "'" +
                ", bevande='" + getBevande() + "'" +
                ", confermato='" + isConfermato() + "'" +
                "}";
    }

}
