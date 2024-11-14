package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

// Interface pour l'écriture des données de symptômes dans une source de sortie.
public interface ISymptomWriter {
    /**
     * Écrit les symptômes et leurs occurrences dans une source spécifiée.
     *
     * @param symptoms une map associant le nom du symptôme à son nombre d'occurrences
     * @throws IOException en cas d'erreur lors de l'écriture
     */
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
