package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

/**
 * Rappresenta il Decoratore Cannella
 */
public class CannellaDecorator extends IngredienteDecorator {

    public CannellaDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    public CannellaDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        super(bevanda, strategy);
    }

    @Override
    protected String getNomeIngrediente() {
        return "cannella";
    }

    @Override
    protected float getCostoIngrediente() {
        return 0.10f;
    }
}
