package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

public class ZuccheroDecorator extends IngredienteDecorator {

    public ZuccheroDecorator(Bevanda bevanda) {
        super("zucchero", 0.30f, bevanda);
    }

    public ZuccheroDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        super("zucchero", 0.30f, bevanda, strategy);
    }

    public void aggiungiZucchero() {
        System.out.println(" Zucchero aggiunto");
    }
}
