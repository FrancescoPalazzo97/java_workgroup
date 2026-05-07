package models.strategies;

public interface QuantitaIngredienteStrategy {
    String modificaDescrizione(String nomeIngrediente);

    float modificaCosto(float costoBaseIngrediente);
}
