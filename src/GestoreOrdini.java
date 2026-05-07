public class GestoreOrdini {
    private static GestoreOrdini instance;

    private GestoreOrdini(){}

    public static GestoreOrdini getinstance(){
        if(instance == null){
            instance = new GestoreOrdini();
        }
        return instance;
    }
}
