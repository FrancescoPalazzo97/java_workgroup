package models.orders;

import models.observers.Observer;

/**
 * Interfaccia Subject
 */
public interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver(Ordine ordineCorrente);
}
