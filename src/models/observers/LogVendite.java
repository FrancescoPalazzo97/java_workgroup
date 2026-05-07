package models.observers;

import models.orders.Ordine;

public class LogVendite implements Observer {

    @Override
    public void update(Ordine ordineCorrente) {
        System.out.println();
        System.out.println("[LOG] Registrata vendita ordine #" + ordineCorrente.getNumeroOrdine()
                + " per " + String.format("Euro %.2f", ordineCorrente.getTotaleOrdine()));
    }

}
