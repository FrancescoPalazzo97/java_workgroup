package controllers;

import models.Bevanda;
import views.BevandaView;

public class BevandaController {
    private Bevanda model;
    private BevandaView view;

    public BevandaController(Bevanda model, BevandaView view) {
        this.model = model;
        this.view = view;
    }

    public void printView() {

    }

    public void selezionaBevanda(int scelta){
        view.mostraBevande();
    }

}
