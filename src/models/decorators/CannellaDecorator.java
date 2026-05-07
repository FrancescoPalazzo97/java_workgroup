package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

public class CannellaDecorator extends IngredienteDecorator {

    public CannellaDecorator(Bevanda bevanda) {
        super("cannella", 0.60f, bevanda);
    }

    public CannellaDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        super("cannella", 0.60f, bevanda, strategy);
    }

    public void aggiungiCannella() {
        System.out.println(" Cannella aggiunta");
    }
}
