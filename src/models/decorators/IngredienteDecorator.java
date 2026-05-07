package models.decorators;

import models.Bevanda;
import models.strategies.NormaleStrategy;
import models.strategies.QuantitaIngredienteStrategy;

public abstract class IngredienteDecorator implements Bevanda {
    protected String nomeIngrediente;
    protected float costoIngrediente;

    protected Bevanda bevanda;
    protected QuantitaIngredienteStrategy strategy;

    public IngredienteDecorator(Bevanda bevanda) {
        this.bevanda = bevanda;
        this.strategy = new NormaleStrategy();
    }

    public IngredienteDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        this.bevanda = bevanda;
        this.strategy = strategy;
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", "
                + strategy.modificaDescrizione(getNomeIngrediente());
    }

    @Override
    public float getCosto() {
        return bevanda.getCosto() + strategy.modificaCosto(getCostoIngrediente());
    }

    protected abstract String getNomeIngrediente();

    protected abstract float getCostoIngrediente();
}