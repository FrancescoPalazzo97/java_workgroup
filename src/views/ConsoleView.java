package views;

import java.util.Scanner;

import models.orders.Ordine;
import models.strategies.ExtraStrategy;
import models.strategies.NormaleStrategy;
import models.strategies.PocoStrategy;
import models.strategies.QuantitaIngredienteStrategy;

public class ConsoleView {
    private Scanner inInt = new Scanner(System.in);

    public int leggiVoceMenu() {
        stampaTitolo("Sistema Bar");
        System.out.println("1 - Crea nuova bevanda");
        System.out.println("2 - Aggiungi ingrediente extra");
        System.out.println("3 - Visualizza bevanda corrente");
        System.out.println("4 - Conferma ordine");
        System.out.println("5 - Visualizza storico ordini");
        System.out.println("0 - Esci");
        return leggiIntero("Scelta: ", 0, 5);
    }

    public int scegliBevandaBase() {
        stampaTitolo("Bevande base");
        System.out.println("1 - Caffe");
        System.out.println("2 - Te");
        System.out.println("3 - Cioccolata calda");
        return leggiIntero("Bevanda: ", 1, 3);
    }

    public int scegliExtra() {
        stampaTitolo("Ingredienti extra");
        System.out.println("1 - Latte");
        System.out.println("2 - Zucchero");
        System.out.println("3 - Panna");
        System.out.println("4 - Cannella");
        return leggiIntero("Extra: ", 1, 4);
    }

    public QuantitaIngredienteStrategy scegliQuantita() {
        stampaTitolo("Quantita");
        System.out.println("1 - Poca");
        System.out.println("2 - Normale");
        System.out.println("3 - Tanta");

        int input = leggiIntero("Quantita: ", 1, 3);
        QuantitaIngredienteStrategy strategy;

        switch (input) {
            case 1:
                strategy = new PocoStrategy();
                break;

            case 2:
                strategy = new NormaleStrategy();
                break;

            case 3:
                strategy = new ExtraStrategy();
                break;

            default:
                strategy = new NormaleStrategy();
                break;
        }

        return strategy;
    }

    public void mostraMessaggio(String messaggio) {
        System.out.println();
        System.out.println(messaggio);
    }

    public void mostraOrdineConfermato(Ordine ordine) {
        mostraMessaggio("Ordine confermato: #" + ordine.getNumeroOrdine());
    }

    private int leggiIntero(String prompt, int minimo, int massimo) {
        while (true) {
            System.out.print(prompt);
            int input = inInt.nextInt();

            if (input >= minimo && input <= massimo) {
                return input;
            }

            System.out.println("Inserisci un numero tra " + minimo + " e " + massimo + ".");
        }
    }

    private void stampaTitolo(String titolo) {
        System.out.println();
        System.out.println("=== " + titolo + " ===");
    }
}
