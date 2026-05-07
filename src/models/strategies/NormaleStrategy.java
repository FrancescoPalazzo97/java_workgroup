package models.strategies;

public class NormaleStrategy implements QuantitaIngredienteStrategy {

    @Override
    public String modificaDescrizione(String nomeIngrediente) {
        return nomeIngrediente;
    }

    @Override
    public float modificaCosto(float costoBaseIngrediente) {
        return costoBaseIngrediente;
    }

}
