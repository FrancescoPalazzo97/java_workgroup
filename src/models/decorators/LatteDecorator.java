package models.decorators;

import models.Bevanda;

public class LatteDecorator extends IngredienteDecorator{
    
    public LatteDecorator(Bevanda bevanda){
        super("latte",0.50f,bevanda);
    }
    
    public void aggiungiLatte(){
        System.out.println(" Aggiunto il latte");
    }

}
