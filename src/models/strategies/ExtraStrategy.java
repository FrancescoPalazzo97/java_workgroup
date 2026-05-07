package models.strategies;

public class ExtraStrategy implements QuantitaIngredienteStrategy {

    @Override
    public String modificaDescrizione(String nomeIngrediente) {
        return "extra " + nomeIngrediente;
    }

    @Override
    public float modificaCosto(float costoBaseIngrediente) {
        return costoBaseIngrediente * 1.2f;
    }

}
