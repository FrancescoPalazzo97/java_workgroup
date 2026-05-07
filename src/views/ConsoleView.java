package views;

import java.util.Scanner;

import observer.Observer;

public class ConsoleView implements Observer {

    Scanner myIntSc = new Scanner(System.in);
    Scanner myStrSc = new Scanner(System.in);
    Scanner myFloatSc = new Scanner(System.in);

    public void mostraMenu() {
        System.out.println(
                "---Menu Bevande--- \n1) Aggiungi nuova bevanda \n2) Aggiungi ingrediente extra \n3) Visualizza bevanda corrente \n4) Conferma ordine \n5) Visualizza Storico ordini \n6) Esci");
    }

    public int scelta() {
        System.out.println("Scelta: ");
        int s = myIntSc.nextInt();
        return s;
    }

    @Override
    public void update() {
        System.out.println("Stato ordine aggiornato");
    }
}
