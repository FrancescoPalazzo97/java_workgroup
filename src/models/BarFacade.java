package models;

import models.decorators.CannellaDecorator;
import models.decorators.LatteDecorator;
import models.decorators.PannaDecorator;
import models.decorators.ZuccheroDecorator;
import models.observers.LogVendite;
import models.orders.GestoreOrdini;
import models.orders.Ordine;
import models.strategies.QuantitaIngredienteStrategy;

/**
 * Rappresenta l'interfaccia semplificata con la quale andrà a interagire il
 * controller
 */
public class BarFacade {
    private GestoreOrdini gestoreOrdini;
    private Bevanda bevanda;

    /**
     * Rappresenta l'interfaccia semplificata con la quale andrà a interagire il
     * controller
     */
    public BarFacade() {
        this.gestoreOrdini = GestoreOrdini.getInstance();
        this.gestoreOrdini.addObserver(new LogVendite());
    }

    /**
     * Metodo che crea la bevanda base in base alla scelta dell'utente
     * Se esiste già una bevanda in costruzione la aggiunge all'ordine e la resetta
     * in modo da poter creare una nuova bevanda
     * 
     * @param sceltaBevandaBase input numerico dell'utente
     */
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

    /**
     * Metodo che aggiunge il Decorator desiderato alla bevanda corrente
     * Se non esiste ancora una bevanda in costruzione stampa un messaggio di errore
     * 
     * @param sceltaExtra      input numerico dell'utente
     * @param quantitaStrategy rappresenta la strategy desiderata
     */
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

    /**
     * Viusializza riepilogo della bevanda corrente se esiste
     * 
     * @return stringa con riepilogo della bavanda o messaggio di errore
     */
    public String visualizzaBevandaCorrente() {
        if (bevanda == null) {
            return "Nessuna bevanda in costruzione.";
        }
        return bevanda.getDescrizione()
                + " - " + String.format("Euro %.2f", bevanda.getCosto());
    }

    /**
     * Metodo per confermare l'ordine
     * 
     * @return ordine corrente confermato
     */
    public Ordine confermaOrdine() {
        finalizzaBevandaInCostruzione();
        return gestoreOrdini.confermaOrdineCorrente();
    }

    /**
     * Viasulizza lo storico ordini
     * 
     * @return stringa che rappresenta lo storico ordini
     */
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

    /**
     * Metodo che aggiunge la bevanda in coustruzione all'ordine corrente e la
     * resetta
     */
    private void finalizzaBevandaInCostruzione() {
        if (bevanda != null) {
            gestoreOrdini.getOrdineCorrente().aggiungiBevanda(bevanda);
            bevanda = null;
        }
    }
}
