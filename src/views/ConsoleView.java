package views;

import java.util.Scanner;

import observer.Observer;

public class ConsoleView implements Observer{
    
    Scanner myIntSc = new Scanner(System.in);
    Scanner myStrSc = new Scanner(System.in);
    Scanner myFloatSc = new Scanner(System.in);

    public void mostraMenu(){
        System.out.println("---Menu Bevande--- \n1) Lista bevande \n2) Scegli bevanda \n3) Visualizza Storico ordini \n4) Esci");
    }

    public int scelta(){
        System.out.println("Scelta: ");
        int s = myIntSc.nextInt();
        return s;
    }

    @Override
    public void update() {
    }
}
