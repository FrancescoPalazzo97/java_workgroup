package models;

import models.decorators.CannellaDecorator;
import models.decorators.LatteDecorator;
import models.decorators.PannaDecorator;
import models.decorators.ZuccheroDecorator;
import models.observers.LogVendite;
import models.orders.GestoreOrdini;
import models.orders.Ordine;
import models.strategies.QuantitaIngredienteStrategy;

public class BarFacade {
    private GestoreOrdini gestoreOrdini;
    private Bevanda bevanda;

    public BarFacade() {
        this.gestoreOrdini = GestoreOrdini.getInstance();
        this.gestoreOrdini.addObserver(new LogVendite());
    }

    public void creaBevandaBase(int sceltaBevandaBase) {
        if (bevanda != null) {
            gestoreOrdini.getOrdineCorrente().aggiungiBevanda(bevanda);
            bevanda = null;
        }

        switch (sceltaBevandaBase) {
            case 1: {
                bevanda = new Caffe();
                break;
            }

            case 2: {
                bevanda = new Te();
                break;
            }

            case 3: {
                bevanda = new Cioccolata();
                break;
            }

            default: {
                System.out.println("Bevanda base non valida");
                break;
            }
        }
    }

    public void aggiungiExtra(int sceltaExtra, QuantitaIngredienteStrategy quantitaStrategy) {
        if (bevanda == null) {
            System.out.println("Crea prima una bevanda base");
            return;
        }

        switch (sceltaExtra) {
            case 1:
                bevanda = new LatteDecorator(bevanda, quantitaStrategy);
                break;

            case 2:
                bevanda = new ZuccheroDecorator(bevanda, quantitaStrategy);
                break;

            case 3:
                bevanda = new PannaDecorator(bevanda, quantitaStrategy);
                break;

            case 4:
                bevanda = new CannellaDecorator(bevanda, quantitaStrategy);
                break;

            default:
                System.out.println("Ingrediente extra non valido");
                break;
        }
    }

    public String visualizzaBevandaCorrente() {
        if (bevanda == null) {
            return "Nessuna bevanda in costruzione.";
        }
        return bevanda.getDescrizione()
                + " - " + String.format("Euro %.2f", bevanda.getCosto());
    }

    public Ordine confermaOrdine() {
        finalizzaBevandaInCostruzione();
        return gestoreOrdini.confermaOrdineCorrente();
    }

    public String visualizzaStoricoOrdini() {
        if (gestoreOrdini.getStoricoOrdini().isEmpty()) {
            return "Nessun ordine nello storico.";
        }

        String storico = "";

        for (Ordine ordine : gestoreOrdini.getStoricoOrdini()) {
            storico += ordine.getRiepilogoOrdine() + "\n";
        }

        return storico;
    }

    private void finalizzaBevandaInCostruzione() {
        if (bevanda != null) {
            gestoreOrdini.getOrdineCorrente().aggiungiBevanda(bevanda);
            bevanda = null;
        }
    }
}
