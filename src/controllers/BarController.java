package controllers;

import models.BarFacade;
import models.orders.Ordine;
import models.strategies.QuantitaIngredienteStrategy;
import views.ConsoleView;

/**
 * Controller che gestisce il sistema sfruttando la view per stampare in console
 * e l'interfaccia semplificata del BarFacade per eseguire le varie operazioni
 */
public class BarController {
    private BarFacade barFacade;
    private ConsoleView consoleView;

    /**
     * Controller che gestisce il sistema sfruttando la view per stampare in console
     * e l'interfaccia semplificata del BarFacade per eseguire le varie operazioni
     */
    public BarController(BarFacade barFacade, ConsoleView consoleView) {
        this.barFacade = barFacade;
        this.consoleView = consoleView;
    }

    /**
     * Metodo principale che avvia tutto il sistema
     */
    public void avvia() {
        boolean inEsecuzione = true; // flag per controllare il ciclo while

        while (inEsecuzione) {
            int scelta = consoleView.leggiVoceMenu();

            switch (scelta) {
                // case 0: termina l'esecuzione
                case 0:
                    inEsecuzione = false;
                    break;

                case 1:
                    creaNuovaBevanda();
                    break;

                case 2:
                    aggiungiIngredienteExtra();
                    break;

                case 3:
                    consoleView.mostraMessaggio(barFacade.visualizzaBevandaCorrente());
                    break;

                case 4:
                    confermaOrdine();
                    break;

                case 5:
                    consoleView.mostraMessaggio(barFacade.visualizzaStoricoOrdini());
                    break;

                default:
                    consoleView.mostraMessaggio("Scelta non valida.");
                    break;
            }
        }

        consoleView.mostraMessaggio("Arrivederci!");
    }

    /**
     * Metodo che sfrutta la view e l'interfaccia semplificata del Facade per creare
     * una nuova bevanda
     */
    private void creaNuovaBevanda() {
        int sceltaBevandaBase = consoleView.scegliBevandaBase();
        barFacade.creaBevandaBase(sceltaBevandaBase);
        consoleView.mostraMessaggio("Bevanda in costruzione: " + barFacade.visualizzaBevandaCorrente());
    }

    /**
     * Metodo che sfrutta la view e l'interfaccia semplificata del Facade per
     * aggiungere ingredienti extra alla bevanda
     */
    private void aggiungiIngredienteExtra() {
        int sceltaExtra = consoleView.scegliExtra();
        QuantitaIngredienteStrategy quantitaStrategy = consoleView.scegliQuantita();
        barFacade.aggiungiExtra(sceltaExtra, quantitaStrategy);
        consoleView.mostraMessaggio("Bevanda aggiornata: " + barFacade.visualizzaBevandaCorrente());
    }

    /**
     * Metodo che sfrutta la view e l'interfaccia semplificata del Facade per
     * confermare l'ordine
     */
    private void confermaOrdine() {
        Ordine ordine = barFacade.confermaOrdine();
        consoleView.mostraOrdineConfermato(ordine);
    }
}
