import controllers.BarController;
import models.BarFacade;
import views.ConsoleView;

public class App {
    public static void main(String[] args) throws Exception {
        BarFacade barFacade = new BarFacade();
        ConsoleView consoleView = new ConsoleView();
        BarController barController = new BarController(barFacade, consoleView);

        barController.avvia();
    }
}
