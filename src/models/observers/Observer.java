package models.observers;

import models.orders.Ordine;

/**
 * Interfaccia Observer
 */
public interface Observer {
    void update(Ordine ordineCorrente);
}
