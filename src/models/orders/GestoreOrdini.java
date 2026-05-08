package models.orders;

import java.util.ArrayList;
import java.util.List;
import models.observers.Observer;

public class GestoreOrdini implements Subject {
    private static GestoreOrdini instance;

    private int prossimoNumero;
    private Ordine ordineCorrente;
    private List<Ordine> storicoOrdini;
    private List<Observer> observers;

    private GestoreOrdini() {
        this.prossimoNumero = 1;
        storicoOrdini = new ArrayList<>();
        observers = new ArrayList<>();
        this.ordineCorrente = new Ordine(prossimoNumero++);
    }

    public static GestoreOrdini getInstance() {
        if (instance == null) {
            instance = new GestoreOrdini();
        }

        return instance;
    }

    public Ordine getOrdineCorrente() {
        return ordineCorrente;
    }

    public List<Ordine> getStoricoOrdini() {
        return this.storicoOrdini;
    }

    /**
     * Metodo che conferma l'ordine in costruzione, lo aggiunge allo storico ordini,
     * notifica gli observer e inizializza il prossimo ordine con numero
     * incrementale.
     * 
     * @return ordine confermato
     */
    public Ordine confermaOrdineCorrente() {
        ordineCorrente.conferma();
        storicoOrdini.add(ordineCorrente);
        notifyObserver(ordineCorrente);

        Ordine confermato = ordineCorrente;
        ordineCorrente = new Ordine(prossimoNumero++);
        return confermato;
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(Ordine ordineCorrente) {
        for (Observer o : observers) {
            o.update(ordineCorrente);
        }
    }

}
