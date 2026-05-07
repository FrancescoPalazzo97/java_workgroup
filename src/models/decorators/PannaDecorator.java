package models.decorators;

import models.Bevanda;
import models.strategies.QuantitaIngredienteStrategy;

public class PannaDecorator extends IngredienteDecorator {

    public PannaDecorator(Bevanda bevanda) {
        super("panna", 0.20f, bevanda);
    }

    public PannaDecorator(Bevanda bevanda, QuantitaIngredienteStrategy strategy) {
        super("panna", 0.20f, bevanda, strategy);
    }

    public void aggiungiPanna() {
        System.out.println(" Panna aggiunta");
    }
}
