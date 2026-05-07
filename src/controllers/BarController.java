package controllers;

import models.BarFacade;
import models.orders.Ordine;
import models.strategies.QuantitaIngredienteStrategy;
import views.ConsoleView;

public class BarController {
    private BarFacade barFacade;
    private ConsoleView consoleView;

    public BarController(BarFacade barFacade, ConsoleView consoleView) {
        this.barFacade = barFacade;
        this.consoleView = consoleView;
    }

    public void avvia() {
        boolean inEsecuzione = true;

        while (inEsecuzione) {
            int scelta = consoleView.leggiVoceMenu();

            switch (scelta) {
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

    private void creaNuovaBevanda() {
        int sceltaBevandaBase = consoleView.scegliBevandaBase();
        barFacade.creaBevandaBase(sceltaBevandaBase);
        consoleView.mostraMessaggio("Bevanda in costruzione: " + barFacade.visualizzaBevandaCorrente());
    }

    private void aggiungiIngredienteExtra() {
        int sceltaExtra = consoleView.scegliExtra();
        QuantitaIngredienteStrategy quantitaStrategy = consoleView.scegliQuantita();
        barFacade.aggiungiExtra(sceltaExtra, quantitaStrategy);
        consoleView.mostraMessaggio("Bevanda aggiornata: " + barFacade.visualizzaBevandaCorrente());
    }

    private void confermaOrdine() {
        Ordine ordine = barFacade.confermaOrdine();
        consoleView.mostraOrdineConfermato(ordine);
    }
}
