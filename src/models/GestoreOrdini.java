package models;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;
import observer.Subject;

public class GestoreOrdini implements Subject {
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

    public boolean hasBevandaCorrente() {
        return bevandaCorrente != null;
    }

    public List<String> getStoricoOrdini() {
        return new ArrayList<>(storicoOrdini);
    }

    public String getRiepilogoBevandaCorrente() {
        if (!hasBevandaCorrente()) {
            return "Nessuna bevanda correte!";
        }

        return creaRiepilogo(bevandaCorrente);
    }

    public void confermaOrdine() {
        if (!hasBevandaCorrente()) {
            return;
        }

        storicoOrdini.add(creaRiepilogo(bevandaCorrente));
        bevandaCorrente = null;
    }

    private String creaRiepilogo(Bevanda bevanda) {
        return bevanda.getDescrizione()
                + " - Totale: "
                + String.format("%.2f", bevanda.getCosto())
                + " euro";
    }

    public void addObserver(Observer o) {
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
