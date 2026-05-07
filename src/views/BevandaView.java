package views;

public class BevandaView {
    public void printView(String descrizione) {
        System.out.println(descrizione);
    };

    public void mostraBevande(){
        System.out.println("1) Caffe \n2) Cioccolata \n3) Te");
    }

    public void mostraIngredienti(){
        System.out.println("1) Cannella \n2) Latte \n3) Panna \n4) Zucchero");
    }
}
