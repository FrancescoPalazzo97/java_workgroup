package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

/**
 * Rappresenta il Decoratore Zucchero
 */
public class ZuccheroDecorator extends IngredienteDecorator {

    public ZuccheroDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    public ZuccheroDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        super(bevanda, strategy);
    }

    @Override
    protected String getNomeIngrediente() {
        return "Zucchero";
    }

    @Override
    protected float getCostoIngrediente() {
        return 0.30f;
    }
}
