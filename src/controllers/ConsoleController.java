package controllers;

import views.ConsoleView;

public class ConsoleController {
    private ConsoleView console;
    private BevandaController bController;

    public ConsoleController(ConsoleView console, BevandaController bController) {
        this.console = console;
        this.bController = bController;
    }

    public void avvia() {
        int scelta;

        do {
            console.mostraMenu();
            scelta = console.scelta();

            switch (scelta) {
                //CREA NUOVA BEVANDA
                case 1:
                    
                    break;

                //AGGIUNGI INGREDIENTI EXTRA
                case 2:
                    break;

                //VISUALIZZA BEVANDA CORRENTE
                case 3:
                    break;
                
                //CONFERMA ORDINE
                case 4:
                    System.out.println("Arrivedrci");
                    break;
                
                //VISUALIZZA SOTRICO ORDINI
                case 5:
                    break;

                //ESCI
                case 6:
                    break;
                
                default: 
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 4);
    }
}
