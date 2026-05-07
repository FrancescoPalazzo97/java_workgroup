package models.decorators;

import models.Bevanda;

public class PannaDecorator extends IngredienteDecorator{

    public PannaDecorator(Bevanda bevanda) {
        super("panna", 0.20f, bevanda);
    }

    public void aggiungiPanna(){
        System.out.println(" Panna aggiunta");
    }
    
}
