package models.observers;

import models.orders.Ordine;

/**
 * Rapresenta il log del sistema il quale logga gli aggiornamenti delle vendite
 * attraverso il design patter Observer
 */
public class LogVendite implements Observer {

    /**
     * Stampa in console il log delle vendite
     * 
     * @param ordineCorrente ordine attualmente in costruzione
     */
    @Override
    public void update(Ordine ordineCorrente) {
        System.out.println();
        System.out.println("[LOG] Registrata vendita ordine #" + ordineCorrente.getNumeroOrdine()
                + " per " + String.format("Euro %.2f", ordineCorrente.getTotaleOrdine()));
    }

}
