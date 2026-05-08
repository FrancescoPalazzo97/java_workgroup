package views;

import java.util.Scanner;

import models.orders.Ordine;
import models.strategies.ExtraStrategy;
import models.strategies.NormaleStrategy;
import models.strategies.PocoStrategy;
import models.strategies.QuantitaIngredienteStrategy;

/**
 * Rappresenta la console con metodi per visualizzare testo e recuperare input
 * la quale verrà sfruttata dal controller
 */
public class ConsoleView {
    private Scanner inInt = new Scanner(System.in);

    /**
     * Stampa il menu principale in console e chiede l'input numerico all'utente
     * 
     * @return input dell'utente
     */
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

    /**
     * Stampa menu di scelta della bevanda base e chiede l'input numerico all'utente
     * 
     * @return input all'utente
     */
    public int scegliBevandaBase() {
        stampaTitolo("Bevande base");
        System.out.println("1 - Caffe");
        System.out.println("2 - Te");
        System.out.println("3 - Cioccolata calda");
        return leggiIntero("Bevanda: ", 1, 3);
    }

    /**
     * Stampa menu di scelta dell'extra da aggiungere alla bevanda oltre a chiedere
     * l'input dell'utente
     * 
     * @return input dell'utente
     */
    public int scegliExtra() {
        stampaTitolo("Ingredienti extra");
        System.out.println("1 - Latte");
        System.out.println("2 - Zucchero");
        System.out.println("3 - Panna");
        System.out.println("4 - Cannella");
        return leggiIntero("Extra: ", 1, 4);
    }

    /**
     * Stampa menu di scelta della quantità dell'extra, chiede input all'utente
     * 
     * @return strategy desidarata
     */
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

    /**
     * Stampa messaggio aggiungendo sopra una linea di spazio
     * 
     * @param messaggio testo da stampare
     */
    public void mostraMessaggio(String messaggio) {
        System.out.println();
        System.out.println(messaggio);
    }

    /**
     * Stampa titolo aggiungendo sopra una linea di spazio
     * 
     * @param titolo titolo da stampare
     */
    private void stampaTitolo(String titolo) {
        System.out.println();
        System.out.println("=== " + titolo + " ===");
    }

    public void mostraOrdineConfermato(Ordine ordine) {
        mostraMessaggio("Ordine confermato: #" + ordine.getNumeroOrdine());
    }

    /**
     * Metodo per leggere l'input numerico dell'utente
     * 
     * @param prompt  messaggio da mostrare in console
     * @param minimo  valore minimo accettabile
     * @param massimo valore massimo accettabile
     * @return input numerico dell'utente
     */
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

}
