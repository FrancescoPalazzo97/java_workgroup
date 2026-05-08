package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

/**
 * Rappresenta il Decoratore Latte
 */
public class LatteDecorator extends IngredienteDecorator {

    public LatteDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    public LatteDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        super(bevanda, strategy);
    }

    @Override
    protected String getNomeIngrediente() {
        return "latte";
    }

    @Override
    protected float getCostoIngrediente() {
        return 0.30f;
    }

}
