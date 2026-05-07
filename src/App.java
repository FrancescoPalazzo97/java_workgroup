import models.GestoreOrdini;
import views.ConsoleView;

public class App {
    public static void main(String[] args) throws Exception {

        ConsoleView console = new ConsoleView();
        GestoreOrdini.getinstance().addObserver(console);        

    }
}
