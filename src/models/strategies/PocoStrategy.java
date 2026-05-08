package models.strategies;

/**
 * Strategy "Poco" la quale modifica descrizione e costo
 */
public class PocoStrategy implements QuantitaIngredienteStrategy {

    @Override
    public String modificaDescrizione(String nomeIngrediente) {
        return "poco " + nomeIngrediente;
    }

    @Override
    public float modificaCosto(float costoBaseIngrediente) {
        return costoBaseIngrediente * 0.8f;
    }

}
