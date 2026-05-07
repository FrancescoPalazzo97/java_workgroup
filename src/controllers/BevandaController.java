package controllers;

import models.Bevanda;
import views.BevandaView;

public abstract class BevandaController {
    private Bevanda model;
    private BevandaView view;

    public BevandaController(Bevanda model, BevandaView view) {
        this.model = model;
        this.view = view;
    }

    public void printView() {

    }
}
