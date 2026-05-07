package models.decorators;

import models.Bevanda;
import models.strategies.NormaleStrategy;
import models.strategies.QuantitaIngredienteStrategy;

public abstract class IngredienteDecorator extends Bevanda {

    protected Bevanda bevanda;
    protected QuantitaIngredienteStrategy strategy;

    public IngredienteDecorator(String descrizione, float costo, Bevanda bevanda) {
        super(descrizione, costo);
        this.bevanda = bevanda;
        this.strategy = new NormaleStrategy();
    }

    public IngredienteDecorator(
            String descrizione,
            float costo,
            Bevanda bevanda,
            QuantitaIngredienteStrategy strategy) {
        super(descrizione, costo);
        this.bevanda = bevanda;
        this.strategy = strategy;
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione()
                + " + "
                + strategy.modificaDescrizione(super.getDescrizione());
    }

    @Override
    public float getCosto() {
        return bevanda.getCosto()
                + strategy.modificaCosto(super.getCosto());
    }
}