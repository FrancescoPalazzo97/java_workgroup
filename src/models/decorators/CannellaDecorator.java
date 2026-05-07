package models.decorators;

import models.Bevanda;

public class CannellaDecorator extends IngredienteDecorator{

    public CannellaDecorator(Bevanda bevanda) {
        super("cannella", 0.60f,bevanda);
    }

    public void aggiungiCannella(){
        System.out.println(" Cannella Aggiunta");
    }
}
