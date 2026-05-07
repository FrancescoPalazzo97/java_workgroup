package models.observers;

import models.orders.Ordine;

public interface Observer {
    void update(Ordine ordineCorrente);
}
