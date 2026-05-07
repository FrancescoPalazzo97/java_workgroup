package models.decorators;

import models.Bevanda;

public class ZuccheroDecorator extends IngredienteDecorator{
    public ZuccheroDecorator(Bevanda bevanda){
        super("zucchero",0.30f,bevanda);
    }

    public void aggiungiZucchero(){
        System.out.println(" Zucchero aggiunto");
    }
}
