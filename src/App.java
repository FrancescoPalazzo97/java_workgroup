import java.util.Scanner;

import controllers.ConsoleController;
import views.BevandaView;
import views.ConsoleView;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner myIntSc = new Scanner(System.in);

        ConsoleView cView = new ConsoleView();
        BevandaView bView = new BevandaView();

        ConsoleController console = new ConsoleController(cView);

        console.avvia();

        int selezione = myIntSc.nextInt(); 
        
            switch (selezione) {
                case 1:
                    bView.mostraBevande();
                    int bevandaScelta = myIntSc.nextInt();
                    break;
            
                default:
                    break;
            }
    }
}
