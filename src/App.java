import java.util.Scanner;

import controllers.ConsoleController;
import models.Bevanda;
import models.Caffe;
import models.Cioccolata;
import models.GestoreOrdini;
import models.Te;
import models.decorators.CannellaDecorator;
import models.decorators.LatteDecorator;
import models.decorators.PannaDecorator;
import models.decorators.ZuccheroDecorator;
import views.BevandaView;
import views.ConsoleView;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner myIntSc = new Scanner(System.in);

        ConsoleView cView = new ConsoleView();
        BevandaView bView = new BevandaView();
        Bevanda bevanda = null;

        ConsoleController console = new ConsoleController(cView);

        boolean loop = true;

        do {
            
            console.avvia();
            int selezione = myIntSc.nextInt();
            switch (selezione) {
                // CREA NUOVA BEVANDA
                case 1:
                    bView.mostraBevande();
                    int bevandaScelta = myIntSc.nextInt();
                    switch (bevandaScelta) {
                        // CAFFE
                        case 1:
                            bevanda = new Caffe("Caffe", 2.00f);
                            GestoreOrdini.getInstance().aggiornaBevandaCorrente(bevanda);
                            break;
                        // CIOCCOLATA
                        case 2:
                            bevanda = new Cioccolata("Cioccolata", 1.50f);
                            GestoreOrdini.getInstance().aggiornaBevandaCorrente(bevanda);
                            break;
                        // TE
                        case 3:
                            bevanda = new Te("Te", 1.00f);
                            GestoreOrdini.getInstance().aggiornaBevandaCorrente(bevanda);
                            break;
                        default:
                            System.out.println("Selezione non valida");
                            break;
                    }
                    break;
                // AGGIUNGI INGREDIENTI
                case 2:
                    Bevanda bCorrente = GestoreOrdini.getInstance().getBevandaCorrente();
                    if (bCorrente == null) {
                        System.out.println("Devi prima scegliere una bevanda");
                        break;
                    }

                    bView.mostraIngredienti();
                    int ingredienteScelta = myIntSc.nextInt();
                    switch (ingredienteScelta) {
                        // CANNELLA
                        case 1:
                            bCorrente = new CannellaDecorator(bCorrente);
                            break;
                        // LATTE
                        case 2:
                            bCorrente = new LatteDecorator(bCorrente);
                            break;
                        // PANNA
                        case 3:
                            bCorrente = new PannaDecorator(bCorrente);
                            break;
                        // ZUCCHERO
                        case 4:
                            bCorrente = new ZuccheroDecorator(bCorrente);
                            break;
                        default:
                            System.out.println("Selezione non valida");
                            break;
                    }
                    GestoreOrdini.getInstance().aggiornaBevandaCorrente(bCorrente);
                    break;
                    // VISUALIZZA BEVANDA CORRENTE
                case 3:
                    System.out.println(GestoreOrdini.getInstance().getBevandaCorrente());
                    break;
                case 4:

                default:
                    System.out.println("Selezione non valida");
                    break;
            }

        } while (loop);
    }
}
