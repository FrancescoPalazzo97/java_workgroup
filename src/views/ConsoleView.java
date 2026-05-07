package views;

import observer.Observer;

public class ConsoleView implements Observer {


    public void mostraMenu() {
        System.out.println("---Menu Bevande--- \n1) Aggiungi nuova bevanda \n2) Aggiungi ingrediente extra \n3) Visualizza bevanda corrente \n4) Conferma ordine \n5) Visualizza Storico ordini \n6) Esci");
    }


    @Override
    public void update() {
        System.out.println("Stato ordine aggiornato");
    }
}
