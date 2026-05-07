package models.orders;

import models.observers.Observer;

public interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
