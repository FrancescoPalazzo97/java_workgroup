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
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                
                case 4:
                    System.out.println("Arrivedrci");
                    break;
                default: 
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 4);
    }
}
