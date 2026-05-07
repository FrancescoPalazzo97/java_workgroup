package models;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;
import observer.Subject;

public class GestoreOrdini implements Subject{
    private static GestoreOrdini instance;

    private Bevanda bevandaCorrente;
    private List<String> storicoOrdini;
    private List<Observer> observer;

    private GestoreOrdini() {
        storicoOrdini = new ArrayList<>();
        observer = new ArrayList<>();
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

    public void addObserver(Observer o){
        observer.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observer.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observer) {
            o.update();
        }
    }

}
