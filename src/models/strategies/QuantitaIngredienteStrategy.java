package models.strategies;

/**
 * Interfaccia per Strategy
 */
public interface QuantitaIngredienteStrategy {
    String modificaDescrizione(String nomeIngrediente);

    float modificaCosto(float costoBaseIngrediente);
}
