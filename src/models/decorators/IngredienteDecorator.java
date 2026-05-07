package models.decorators;

import models.Bevanda;

public abstract class IngredienteDecorator extends Bevanda {

    protected Bevanda bevanda;

    public IngredienteDecorator(String descrizione, float costo, Bevanda bevanda) {
        super(descrizione, costo);
        this.bevanda = bevanda;
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + " + super.getDescrizione();
    }

    @Override
    public float getCosto() {
        return bevanda.getCosto() + super.getCosto();
    }
}