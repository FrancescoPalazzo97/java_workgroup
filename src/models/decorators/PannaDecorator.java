package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

public class PannaDecorator extends IngredienteDecorator {

    public PannaDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    public PannaDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        super(bevanda, strategy);
    }

    @Override
    protected String getNomeIngrediente() {
        return "panna";
    }

    @Override
    protected float getCostoIngrediente() {
        return 0.30f;
    }
}
