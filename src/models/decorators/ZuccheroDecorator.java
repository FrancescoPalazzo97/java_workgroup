package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

public class ZuccheroDecorator extends IngredienteDecorator {

    public ZuccheroDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    public ZuccheroDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
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
