package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Interface pour l'écriture des symptômes et de leurs occurrences dans une source de sortie.
 */
public interface ISymptomWriter {
    /**
     * Écrit les symptômes et leurs occurrences dans la source de sortie spécifiée.
     * 
     * @param symptoms une map contenant les noms des symptômes et leur nombre d'occurrences
     * @throws IOException si une erreur se produit lors de l'écriture
     */
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}