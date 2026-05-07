package controllers;

import views.ConsoleView;

public class ConsoleController {
    private ConsoleView console;

    public ConsoleController(ConsoleView console) {
        this.console = console;
    }

    public void avvia() {
        console.mostraMenu();
    }
}
