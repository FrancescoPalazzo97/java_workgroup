package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

public class LatteDecorator extends IngredienteDecorator {

    public LatteDecorator(Bevanda bevanda) {
        super("latte", 0.50f, bevanda);
    }

    public LatteDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        super("latte", 0.50f, bevanda, strategy);
    }

    public void aggiungiLatte() {
        System.out.println(" Aggiunto il latte");
    }

}
