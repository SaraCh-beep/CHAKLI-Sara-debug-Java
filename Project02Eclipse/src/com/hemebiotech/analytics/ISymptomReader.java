package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Interface pour la lecture des symptômes depuis une source d'entrée.
 */
public interface ISymptomReader {
    /**
     * Lit les symptômes depuis une source d'entrée.
     * 
     * @return une liste contenant les symptômes lus
     * @throws IOException si une erreur se produit lors de la lecture
     */
    List<String> getSymptoms() throws IOException;
}